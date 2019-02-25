package com.infostretch.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.espresso.ViewInteraction;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.infostretch.android.core.AutomationCore;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.infostretch.android.utils.xpath.WithXPath.withXPath;

public class LocatorUtils {
    private static final String ID_PATTERN = "[\\S]+:id/[\\S]+";

    public static ViewInteraction getViewInteraction(String strategy, String selector) {
        String s = strategy.toUpperCase();
        switch (s) {
            case "ID":
                Context targetContext = AutomationCore.getInstance().getInstrumentation().getTargetContext();
                int id = targetContext.getResources().getIdentifier(selector, "id", targetContext.getPackageName());
                Log.d("ID_LOCATORSUTIL", String.valueOf(id));
                return onView(withId(id));
            case "TEXT":
                return onView(withText(selector));
            case "ACCESSIBILITY_ID":
                return onView(withContentDescription(selector));
            case "XPATH":
                return onView(withXPath(selector));

        }
        return null;
    }

    public static ViewInteraction getViewLocator(String key) {
        Context context = AutomationCore.getInstance().getInstrumentation().getContext();
        Resources resources = context.getResources();
        int id = resources.getIdentifier(key, "string", context.getPackageName());

        String strategy = "xpath";
        String selector = "";
        String value = key;
        if (id != 0) {
            value = resources.getString(id);
        }
        if (value.indexOf('=') > 0) {
            String[] arrOfValue = value.split("=", 2);
            strategy = arrOfValue[0];
            selector = arrOfValue[1];
        } else {
            selector = value;
        }
        return getViewInteraction(strategy, selector);
    }


    public static UiObject getUIViewLocator(String key) {
        Context context = AutomationCore.getInstance().getInstrumentation().getContext();
        Resources resources = context.getResources();
        int id = resources.getIdentifier(key, "string", context.getPackageName());
        String value = resources.getString(id);
        String[] arrOfValue = value.split("=", 2);
        String prefix = arrOfValue[0];
        String suffix = arrOfValue[1];
        Log.d("suffix", suffix);
        Log.d("prefix", prefix);
        return getUIViewInteraction(prefix, suffix);
    }
    public static List<UiObject2> getUIViewsLocator(String key) {
        Context context = AutomationCore.getInstance().getInstrumentation().getContext();
        Resources resources = context.getResources();
        int id = resources.getIdentifier(key, "string", context.getPackageName());
        String value = resources.getString(id);
        String[] arrOfValue = value.split("=", 2);
        String prefix = arrOfValue[0];
        String suffix = arrOfValue[1];
        Log.d("suffix", suffix);
        Log.d("prefix", prefix);
        return getUIViewsInteraction(prefix, suffix);
    }

    public static UiObject getUIViewInteraction(String strategy, String selector) {
        String s = strategy.toUpperCase();
        UiSelector uiSelector = new UiSelector();
        switch (s) {
            case "ID":
                if (!selector.contains(":id/"))
                    selector = AutomationCore.getInstance().getUiDevice().getCurrentPackageName() + ":id/" + selector;
            case "TEXT":
                // containsText matches is case insensitive
                // text is case sensitive....
                return AutomationCore.getInstance().getUiDevice().findObject(uiSelector.text(selector));
            case "ACCESSIBILITY_ID":

            case "CONTDESC":
                return AutomationCore.getInstance().getUiDevice().findObject(uiSelector.descriptionContains(selector));
        }
        return null;
    }

    public static List<UiObject2> getUIViewsInteraction(String strategy, String selector) {
        String s = strategy.toUpperCase();
        UiSelector uiSelector = new UiSelector();
        switch (s) {
            case "ID":
                if (!selector.contains(":id/"))
                    selector = AutomationCore.getInstance().getUiDevice().getCurrentPackageName() + ":id/" + selector;
                return AutomationCore.getInstance().getUiDevice().findObjects(By.res(selector));
            case "TEXT":
                // containsText matches is case insensitive
                // text is case sensitive....
                return AutomationCore.getInstance().getUiDevice().findObjects(By.text(selector));
            case "ACCESSIBILITY_ID":

            case "CONTDESC":
                return AutomationCore.getInstance().getUiDevice().findObjects(By.descContains(selector));
        }
        return null;
    }
}
