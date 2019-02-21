package com.fastaccess.github.tests;

import android.util.Log;

import com.fastaccess.helper.GithubHelper;
import com.fastaccess.github.steps.ProfileSteps;
import com.infostretch.android.core.BaseTestCase;

import org.junit.Before;
import org.junit.Test;

import static com.fastaccess.github.steps.LoginSteps.openApp;
import static com.fastaccess.github.steps.ProfileSteps.*;

public class ProfileTestCases extends BaseTestCase {
    @Before
    public void suitUp(){
        openApp();
    }

    @Test
    public void followersCountTest(){
        openMyProfile();
        int count = GithubHelper.getFollowingCount();
        Log.d("", String.valueOf(count));
        verifyFollowersCount(count);
    }

}
