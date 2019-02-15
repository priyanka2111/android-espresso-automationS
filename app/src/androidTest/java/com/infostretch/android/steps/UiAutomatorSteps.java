package com.infostretch.android.steps;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.infostretch.android.core.NoSuchElementFoundException;
import com.infostretch.android.utils.LocatorUtils;

public class UiAutomatorSteps {
    public static void click(String loc) {
        try {
            getUIElement(loc).click();
        } catch (UiObjectNotFoundException e) {
            throw new NoSuchElementFoundException(e);
        }
    }

    public static void sendKeys(String loc, String text) {
        sendKeys(loc, text, false);
    }

    public static void sendKeys(String loc, String text, boolean hideKeyboard) {
        try {
            if (hideKeyboard == true) {
                getUIElement(loc).setText(text);
            } else {
                getUIElement(loc).setText(text);
            }
        } catch (UiObjectNotFoundException e) {
            throw new NoSuchElementFoundException(e);
        }
    }

    public static UiObject getUIElement(String loc) {
        return LocatorUtils.getUIViewLocator(loc);
    }
}
