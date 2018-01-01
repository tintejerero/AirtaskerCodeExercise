package com.example.airtaskercodetest.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.airtaskercodetest.R;
import com.example.airtaskercodetest.adapter.FeedAdapter;
import com.example.airtaskercodetest.models.DisplayFeedItem;
import com.example.airtaskercodetest.models.FeedItem;
import com.example.airtaskercodetest.models.Profile;
import com.example.airtaskercodetest.models.Task;
import com.example.airtaskercodetest.network.FeedApi;
import com.example.airtaskercodetest.network.FeedClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedActivity extends AppCompatActivity {
    private static final String TAG = "FeedActivity";

    private List<DisplayFeedItem> mDisplayFeedItemList = new ArrayList<>();
    private FeedApi mFeedApi;
    private FeedAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mAdapter = new FeedAdapter(mDisplayFeedItemList);

        RecyclerView recyclerView = findViewById(R.id.event_feed_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        fetchData();
    }

    private void fetchData() {
        mFeedApi = FeedClient.getClient().create(FeedApi.class);
        Call<List<FeedItem>> call = mFeedApi.getFeedItems();
        call.enqueue(new Callback<List<FeedItem>>() {

            @Override
            public void onResponse(@NonNull Call<List<FeedItem>> call, @NonNull Response<List<FeedItem>> response) {
                if (response.isSuccessful()) {
                    final List<FeedItem> feedItemList = response.body();
                    mapFeedEntries(feedItemList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<FeedItem>> call, @NonNull Throwable t) {
                Log.d(TAG, "getFeedItems() " + t.toString());
                call.cancel();
            }
        });
    }

    private void mapFeedEntries(final List<FeedItem> feedItemList) {
        if (feedItemList != null) {
            for (int i = 0; i < feedItemList.size(); i++) {
                final DisplayFeedItem displayFeedItem = new DisplayFeedItem(feedItemList.get(i));

                mDisplayFeedItemList.add(displayFeedItem);

                Call<Task> call1 = mFeedApi.getTask(displayFeedItem.getTaskId());
                call1.enqueue(new Callback<Task>() {
                    @Override
                    public void onResponse(@NonNull Call<Task> call, @NonNull Response<Task> response) {

                        if (response.isSuccessful()) {

                            updateTaskName(response.body(), displayFeedItem);

                            Call<Profile> call2 = mFeedApi.getProfile(displayFeedItem.getProfileId());
                            call2.enqueue(new Callback<Profile>() {
                                @Override
                                public void onResponse(@NonNull Call<Profile> call, @NonNull Response<Profile> response) {
                                    if (response.isSuccessful()) {

                                        Profile profile = response.body();
                                        updateFirstName(profile, displayFeedItem);
                                        setAvatarMiniUrl(profile, displayFeedItem);

                                        mAdapter.notifyDataSetChanged();
                                    }
                                }

                                @Override
                                public void onFailure(@NonNull Call<Profile> call, @NonNull Throwable t) {
                                    Log.d(TAG, "getProfile() " + t.toString());
                                    call.cancel();
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Task> call, @NonNull Throwable t) {
                        Log.d(TAG, "getTask() " + t.toString());
                        call.cancel();
                    }
                });
            }
        }
    }

    protected void updateTaskName(Task task, DisplayFeedItem displayFeedItem) {
        if (task != null) {
            displayFeedItem.setText(displayFeedItem.getText().replace("{taskName}", "\"" + task.getName() + "\""));
        }
    }

    protected void updateFirstName(Profile profile, DisplayFeedItem displayFeedItem) {
        if (profile != null) {
            displayFeedItem.setText(displayFeedItem.getText().replace("{profileName}", profile.getFirstName()));
        }
    }

    protected void setAvatarMiniUrl(Profile profile, DisplayFeedItem displayFeedItem) {
        String avatarMiniUrl = "";

        if (profile != null) {
            avatarMiniUrl = profile.getAvatarMiniUrl();
        }

        displayFeedItem.setAvatarMiniUrl(avatarMiniUrl);
    }

}