package com.fastaccess.github.tests;

import com.infostretch.android.EspressoXpathSupportUtils.AppiumException;
import com.infostretch.android.EspressoXpathSupportUtils.ViewGetter;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.infostretch.android.EspressoXpathSupportUtils.WithXPath.withXPath;
import static com.infostretch.android.steps.ApplicationSteps.startApp;

public class EspressoXpathDemoTest {

    @Test
    public void xPathTest(){
        startApp();
        try {
            onView(withXPath(new ViewGetter().getRootView(),"//android.widget.LinearLayout[@index='2']")).check(matches(isDisplayed()));
        } catch (AppiumException e) {
            e.printStackTrace();
        }
    }
}
