package com.example.airtaskercodetest.models;

import com.example.airtaskercodetest.enums.TaskState;
import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("id") private int taskId;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("state") private TaskState state;
    @SerializedName("poster_id") private int posterId;
    @SerializedName("worker_id") private int workerId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
