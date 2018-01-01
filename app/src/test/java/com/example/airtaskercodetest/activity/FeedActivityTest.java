package com.example.airtaskercodetest.activity;

import com.example.airtaskercodetest.models.DisplayFeedItem;
import com.example.airtaskercodetest.models.Profile;
import com.example.airtaskercodetest.models.Task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FeedActivityTest {
    private static final String INPUT_TEXT = "{profileName} asked a question about {taskName}";
    private static final String PROFILE_NAME_PATTERN = "{profileName}";
    private static final String TASK_NAME_PATTERN = "{taskName}";
    private static final String TEST_TEXT = " asked a question about ";

    private FeedActivity mFeedActivity = new FeedActivity();
    private DisplayFeedItem mDisplayFeedItem = new DisplayFeedItem();

    @Before
    public void setUp() throws Exception {
        mDisplayFeedItem.setText(INPUT_TEXT);
    }

    @Test
    public void updateTaskNameWithNullTask() throws Exception {
        mFeedActivity.updateTaskName(null, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getText().equals(INPUT_TEXT));
    }

    @Test
    public void updateTaskNameWithValidTask() throws Exception {
        Task task = new Task();
        task.setName("Do 700 push ups in 1 hour");

        mFeedActivity.updateTaskName(task, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getText()
                .equals(PROFILE_NAME_PATTERN + TEST_TEXT + "\"" + task.getName() + "\""));
    }

    @Test
    public void updateFirstNameWithNullProfile() throws Exception {
        mFeedActivity.updateFirstName(null, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getText().equals(INPUT_TEXT));
    }

    @Test
    public void updateFirstNameWithValidProfile() throws Exception {
        Profile profile = new Profile();
        profile.setFirstName("Tinkywinky");

        mFeedActivity.updateFirstName(profile, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getText()
                .equals(profile.getFirstName() + TEST_TEXT + TASK_NAME_PATTERN));
    }

    @Test
    public void setAvatarMiniUrlWithNullProfile() throws Exception {
        mFeedActivity.setAvatarMiniUrl(null, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getAvatarUrl().equals(""));
    }

    @Test
    public void setAvatarMiniUrlWithEmptyString() throws Exception {
        Profile profile = new Profile();
        profile.setAvatarMiniUrl("");

        mFeedActivity.setAvatarMiniUrl(profile, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getAvatarUrl().equals(""));
    }

    @Test
    public void setAvatarMiniUrlWithValidString() throws Exception {
        Profile profile = new Profile();
        profile.setAvatarMiniUrl("/img/4.jpg");

        mFeedActivity.setAvatarMiniUrl(profile, mDisplayFeedItem);
        assertTrue(mDisplayFeedItem.getAvatarUrl()
                .equals(DisplayFeedItem.BASE_URL + profile.getAvatarMiniUrl()));
    }

}