package com.example.airtaskercodetest.enums;

import com.google.gson.annotations.SerializedName;

public enum Event {
    @SerializedName("post")POST,
    @SerializedName("comment")COMMENT,
    @SerializedName("assigned")ASSIGNED,
    @SerializedName("completed")COMPLETED
}
