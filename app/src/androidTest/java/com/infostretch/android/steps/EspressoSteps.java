package com.infostretch.android.steps;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;

import com.infostretch.android.utils.LocatorUtils;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

public class EspressoSteps {

    public static void click(String loc) {
        getElement(loc).perform(ViewActions.click());
    }

    public static void sendKeys(String loc, String text) {
        sendKeys(loc,text,false);

    }

    public static void sendKeys(String loc, String text, boolean hideKeyboard) {
        if(hideKeyboard==true){
            getElement(loc).perform(ViewActions.typeText(text),closeSoftKeyboard());
        }else{
            getElement(loc).perform(ViewActions.typeText(text));
        }
    }


    public static ViewInteraction getElement(String loc){
        return LocatorUtils.getViewLocator(loc);
    }
}
