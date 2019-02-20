package com.fastaccess.github.tests;

import com.infostretch.android.exceptions.AutomationException;
import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.utils.xpath.ViewGetter;

import org.junit.Test;

import java.io.IOException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.infostretch.android.utils.xpath.WithXPath.withXPath;
import static com.infostretch.android.steps.ApplicationSteps.startApp;

public class EspressoXpathDemoTest {

    @Test
    public void xPathTest() {
        startApp();
        EspressoSteps.click("just.test");


    }

}
