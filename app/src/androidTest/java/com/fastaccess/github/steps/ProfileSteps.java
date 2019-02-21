package com.fastaccess.github.steps;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.steps.UiAutomatorSteps;

import junit.framework.Assert;

public class ProfileSteps {

    public static void openMyProfile(){
        UserHomeSteps.openDrawer();
        UserHomeSteps.navigateTo("home.ui.drawer.profile.loc");
    }

    public static void validateOnProfilePage(){
        EspressoSteps.IsDisplayed("profile.ui.following.btn.loc");
    }

    public static void verifyFollowersCount(int count){
        try {
            String mytext = UiAutomatorSteps.getUIElement("profile.ui.following.btn.loc").getText();
            int numberOnly= Integer.parseInt(mytext.replaceAll("[^0-9]", ""));
            Assert.assertEquals(count,numberOnly);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}
