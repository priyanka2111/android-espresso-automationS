package com.infostretch.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import com.infostretch.android.core.AutomationCore;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.fastaccess.helper.ActivityHelper.getActivity;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.instanceOf;

import android.util.Log;
import android.view.View;

import java.util.List;

public class LocatorUtils {
    private static final String ID_PATTERN = "[\\S]+:id/[\\S]+";

    public static ViewInteraction getViewInteraction(String strategy, String selector) {
        String s = strategy.toUpperCase();
        switch (s) {
            case "ID":
                Context targetContext = AutomationCore.getInstance().getInstrumentation().getTargetContext();
                int id = targetContext.getResources().getIdentifier(selector,"id",targetContext.getPackageName());
                Log.d("ID_LOCATORSUTIL",String.valueOf(id));
                return onView(withId(id));
            case "TEXT":
                return onView(withText(selector));
            case "ACCESSIBILITY_ID":
                return onView(withContentDescription(selector));

        }
        return null;
    }

    public static ViewInteraction getViewLocator(String key) {
        Context context = AutomationCore.getInstance().getInstrumentation().getContext();
        Resources resources = context.getResources();
        int id = resources.getIdentifier(key,"string",context.getPackageName());
        String value = resources.getString(id);
        String[] arrOfValue = value.split("=", 2);
        String prefix = arrOfValue[0];
        String suffix = arrOfValue[1];
        Log.d("suffix",suffix);
        Log.d("prefix",prefix);
        return getViewInteraction(prefix, suffix);
    }

}
