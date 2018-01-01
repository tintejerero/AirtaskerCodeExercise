package com.example.airtaskercodetest.models;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("id") private int profileId;
    @SerializedName("avatar_mini_url") private String avatarMiniUrl;
    @SerializedName("first_name") private String firstName;
    @SerializedName("rating") private int rating;

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getAvatarMiniUrl() {
        return avatarMiniUrl;
    }

    public void setAvatarMiniUrl(String avatarMiniUrl) {
        this.avatarMiniUrl = avatarMiniUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("SameParameterValue")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
