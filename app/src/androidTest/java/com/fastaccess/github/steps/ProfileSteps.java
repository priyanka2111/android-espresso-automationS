package com.fastaccess.github.steps;

import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.fastaccess.helper.GithubHelper;
import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.steps.UiAutomatorSteps;

import junit.framework.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfileSteps {

    public static void openMyProfile(){
        UserHomeSteps.openDrawer();
        UserHomeSteps.navigateTo("home.ui.drawer.profile.loc");
    }

    public static void validateOnProfilePage(){
        EspressoSteps.IsDisplayed("profile.ui.following.btn.loc");
    }

    public static void verifyFollowingCount(int count){
        try {
            String mytext = UiAutomatorSteps.getUIElement("profile.ui.following.btn.loc").getText();
            int numberOnly= Integer.parseInt(mytext.replaceAll("[^0-9]", ""));
            Assert.assertEquals(count,numberOnly);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void verifyFollowersCount(int count){
        String mytext = null;
        try {
            mytext = UiAutomatorSteps.getUIElement("profile.ui.followers.btn.loc").getText();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        int numberOnly= Integer.parseInt(mytext.replaceAll("[^0-9]", ""));
        Assert.assertEquals(count,numberOnly);
    }

    public static void verifyCompanyName(String name){
        String mytext = null;
        try {
             mytext = UiAutomatorSteps.getUIElement("profile.ui.organization.btn.loc").getText();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(name,mytext);
    }

    public static void verifyFullName(String name){
        String mytext = null;
        try {
            mytext = UiAutomatorSteps.getUIElement("profile.ui.fullname.text.loc").getText();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(name,mytext);
    }

    public static void verifyBlogName(String name){
        String mytext= null;
        try {
            mytext = UiAutomatorSteps.getUIElement("profile.ui.blog.text.loc").getText();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(name,mytext);
    }

    public static void verifyLocation(String name){
        String mytext = null;
        try {
            mytext = UiAutomatorSteps.getUIElement("profile.ui.location.text.loc").getText();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(name,mytext);
    }

    public static void switchTab(String loc){
        UiAutomatorSteps.scrollHorizontal(loc);
        UiAutomatorSteps.click(loc);
    }

    public static void trya(String loc){
        List<UiObject2> x = UiAutomatorSteps.getUIElements(loc);
        for(UiObject2 z : x){
            Log.d("hellraise",z.getText());
        }

    }

    public static Set<String> fetchGists(String loc){
        Set<String> hash_Set = new HashSet<String>();
        List<UiObject2> x = UiAutomatorSteps.getUIElements(loc);
        for(UiObject2 z : x){
            hash_Set.add(z.getText());
        }
        try {
            UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
            appViews.setAsVerticalList();
            appViews.scrollForward(100);
            List<UiObject2> y = UiAutomatorSteps.getUIElements(loc);
            for(UiObject2 z : y){
                hash_Set.add(z.getText());
            }
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return hash_Set;
    }

    public static void verifyGistPresent(){
        Set<String> my_set = fetchGists("gists.ui.title.text.loc");
        Assert.assertEquals(GithubHelper.areGistPresent(my_set),true);

    }
}
