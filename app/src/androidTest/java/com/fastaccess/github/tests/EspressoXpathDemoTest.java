package com.fastaccess.github.tests;

import com.fastaccess.github.steps.UserHomeSteps;

import org.junit.Test;

import static com.infostretch.android.utils.xpath.WithXPath.withXPath;
import static com.infostretch.android.steps.ApplicationSteps.startApp;

public class EspressoXpathDemoTest {

    @Test
    public void xPathTest() throws InterruptedException {
        startApp();
//        EspressoSteps.click("just.test");
        UserHomeSteps.openDrawer();
        UserHomeSteps.navigateTo("home.ui.drawer.top.profile.loc");
        UserHomeSteps.navigateTo("home.ui.drawer.pinned.loc");
        Thread.sleep(2000);
    }

}
