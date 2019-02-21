package com.fastaccess.github.steps;

import android.support.test.espresso.Espresso;

import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.steps.UiAutomatorSteps;

public class UserHomeSteps {

    /**
        Bottom Navigation:
        Input Params --> Locators for : [Feeds,Issues,Pull Requests]
     */
    public static void bottomNavigateTo(String loc){
        EspressoSteps.click(loc);
    }

    public static void openDrawer(){
        UiAutomatorSteps.click("home.ui.menu.drawer.loc");
    }
    /**
        All options in Drawer.... or any navigations in other tabs
        Input Params --> Locators for : [MENU,PROFILE]
     */
    public static void navigateTo(String loc){
        UiAutomatorSteps.click(loc);
    }


}
