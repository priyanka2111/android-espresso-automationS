package com.infostretch.android.steps;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;

import com.infostretch.android.core.AutomationCore;
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


    public static void presenceOfElementLocated(String loc) throws Exception {
        presenceOfElementLocated(loc, 5000);
    }

    public static void presenceOfElementLocated(String loc, long timeout) throws Exception {

        BySelector byselector = getBySelector(loc);
        AutomationCore.getInstance().getUiDevice().wait(Until.hasObject(byselector), timeout);
    }


    private static BySelector getBySelector(String loc) throws Exception {
        Context context = AutomationCore.getInstance().getInstrumentation().getContext();
        Resources resources = context.getResources();
        int id = resources.getIdentifier(loc, "string", context.getPackageName());
        String value = resources.getString(id);
        String[] arrOfValue = value.split("=", 2);
        String prefix = arrOfValue[0];
        String suffix = arrOfValue[1];
        return getSelector(prefix, suffix);
    }

    private static BySelector getSelector(String strategy, String text) throws Exception {

        String s = strategy.toUpperCase();
        ;
        BySelector selector = null;
        switch (s) {
            case "CLASSNAME":
                selector = By.clazz(text);
                break;
            case "TEXT":
                selector = By.text(text);
                break;
            case "ID":
                selector = By.res(text);
                break;
            case "CONTDESC":
            case "ACCESSIBILITY_ID":
                selector = By.desc(text);
                break;
        }
        return selector;
    }


    public static UiObject getUIElement(String loc) {
        return LocatorUtils.getUIViewLocator(loc);
    }
}
