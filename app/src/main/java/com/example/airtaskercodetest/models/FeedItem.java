package com.example.airtaskercodetest.models;

import com.example.airtaskercodetest.enums.Event;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@SuppressWarnings("WeakerAccess")
public class FeedItem {
    @SerializedName("task_id") private int taskId;
    @SerializedName("profile_id") private int profileId;
    @SerializedName("text") private String text;
    @SerializedName("created_at") private Date createdAt;
    @SerializedName("event") private Event event;

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
