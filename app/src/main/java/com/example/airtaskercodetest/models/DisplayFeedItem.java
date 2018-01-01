package com.example.airtaskercodetest.models;

import com.example.airtaskercodetest.enums.Event;

import java.util.Date;

public class DisplayFeedItem {
    public static final String BASE_URL = "https://stage.airtasker.com/android-code-test";

    private int taskId;
    private int profileId;
    private String avatarMiniUrl;
    private String text;
    private Date createdAt;
    private Event event;

    public DisplayFeedItem() {
    }

    public DisplayFeedItem(FeedItem feedItem) {
        this.taskId = feedItem.getTaskId();
        this.profileId = feedItem.getProfileId();
        this.avatarMiniUrl = "";
        this.text = feedItem.getText();
        this.createdAt = feedItem.getCreatedAt();
        this.event = feedItem.getEvent();
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getAvatarUrl() {
        if (avatarMiniUrl.equals("")) {
            return "";
        } else {
            return BASE_URL + avatarMiniUrl;
        }
    }

    public void setAvatarMiniUrl(String avatarMiniUrl) {
        this.avatarMiniUrl = avatarMiniUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
