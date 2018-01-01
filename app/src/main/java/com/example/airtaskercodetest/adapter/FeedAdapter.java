package com.example.airtaskercodetest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airtaskercodetest.R;
import com.example.airtaskercodetest.models.DisplayFeedItem;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedItemViewHolder>{
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("EEE HH:mma", Locale.getDefault());

    private List<DisplayFeedItem> mDisplayFeedItemList;

    public FeedAdapter(List<DisplayFeedItem> displayFeedItemList) {
        mDisplayFeedItemList = displayFeedItemList;
    }

    @SuppressWarnings("WeakerAccess")
    public class FeedItemViewHolder extends RecyclerView.ViewHolder{
        ImageView mAvatarImageView;
        TextView mDescriptionTextView;
        TextView mDateTextView;
        TextView mEventTextView;

        FeedItemViewHolder(View itemView) {
            super(itemView);
            mAvatarImageView = itemView.findViewById(R.id.feed_item_avatar_image_view);
            mDescriptionTextView = itemView.findViewById(R.id.feed_item_description_text_view);
            mDateTextView = itemView.findViewById(R.id.feed_item_date_text_view);
            mEventTextView = itemView.findViewById(R.id.feed_item_event_text_view);
        }
    }

    @Override
    public FeedAdapter.FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        return new FeedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, final int position) {
        DisplayFeedItem displayFeedItem = mDisplayFeedItemList.get(position);

        setAvatar(displayFeedItem, holder.mAvatarImageView, R.drawable.ic_android_black_100dp);
        holder.mDescriptionTextView.setText(displayFeedItem.getText());
        holder.mDateTextView.setText(SIMPLE_DATE_FORMAT.format(displayFeedItem.getCreatedAt()));
        holder.mEventTextView.setText(displayFeedItem.getEvent().name().toLowerCase());
    }

    private void setAvatar(DisplayFeedItem displayFeedItem, ImageView imageView, int placeholderDrawable) {
        String avatarUrl = displayFeedItem.getAvatarUrl();

        if (avatarUrl.equals("")) {
            imageView.setImageResource(placeholderDrawable);
        } else {
            Picasso.with(imageView.getContext())
                    .load(displayFeedItem.getAvatarUrl())
                    .resizeDimen(R.dimen.avatar_dimension, R.dimen.avatar_dimension)
                    .centerCrop()
                    .into(imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mDisplayFeedItemList.size();
    }
}
