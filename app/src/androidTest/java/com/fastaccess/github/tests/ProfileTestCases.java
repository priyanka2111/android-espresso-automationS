package com.fastaccess.github.tests;

import android.util.Log;

import com.fastaccess.helper.GithubHelper;
import com.fastaccess.github.steps.ProfileSteps;
import com.infostretch.android.core.BaseTestCase;
import com.infostretch.android.steps.UiAutomatorSteps;

import org.junit.Before;
import org.junit.Test;
import org.kohsuke.github.GitHub;

import static com.fastaccess.github.steps.LoginSteps.openApp;
import static com.fastaccess.github.steps.ProfileSteps.*;

public class ProfileTestCases extends BaseTestCase {
    @Before
    public void suitUp(){
        openApp();
        openMyProfile();
    }

    @Test
    public void followingCountTest(){
        int count = GithubHelper.getFollowingCount();
        Log.d("", String.valueOf(count));
        verifyFollowingCount(count);
    }

    @Test
    public void followersCountTest(){
        int count = GithubHelper.getFollowersCount();
        Log.d("", String.valueOf(count));
        verifyFollowersCount(count);
    }
    @Test
    public void companyNameTest(){
        String cName = GithubHelper.getCompanyName();
        Log.d("Company Name",cName);
        verifyCompanyName(cName);
    }
    @Test
    public void blogNameTest(){
        String cName = GithubHelper.getBlog();
        Log.d("Blog Name",cName);
        verifyBlogName(cName);
    }
    @Test
    public void locationNameTest(){
        String cName = GithubHelper.getLocation();
        Log.d("Location",cName);
        verifyLocation(cName);
    }
    @Test
    public void fullNameTest(){
        String cName = GithubHelper.getName();
        Log.d("FullName",cName);
        verifyFullName(cName);
    }

    @Test
    public void gistPresentTest(){
        switchTab("profile.ui.horiscrollbar.text.loc");
        verifyGistPresent();
    }

}
