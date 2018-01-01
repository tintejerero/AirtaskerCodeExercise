package com.example.airtaskercodetest.network;

import com.example.airtaskercodetest.models.FeedItem;
import com.example.airtaskercodetest.models.Profile;
import com.example.airtaskercodetest.models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FeedApi {
    @GET("feed.json")
    Call<List<FeedItem>> getFeedItems();

    @GET("task/{id}.json")
    Call<Task> getTask(@Path("id") int taskId);

    @GET("profile/{id}.json")
    Call<Profile> getProfile(@Path("id") int profileId);
}
