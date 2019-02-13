package com.infostretch.android.steps;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;

import com.infostretch.android.utils.LocatorUtils;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;

public class EspressoSteps {

    public static void click(int loc) {
        getElement(loc).perform(ViewActions.click());
    }

    public static void sendKeys(int loc, String text) {
        sendKeys(loc,text,false);

    }

    public static void sendKeys(int loc, String text, boolean hideKeyboard) {
        if(hideKeyboard==true){
            getElement(loc).perform(ViewActions.typeText(text),closeSoftKeyboard());
        }else{
            getElement(loc).perform(ViewActions.typeText(text));
        }
    }

    public static ViewInteraction getElement(int loc){
        return LocatorUtils.getViewLocator(loc);
    }
}
