package com.infostretch.android.steps;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;
import android.view.View;

import com.fastaccess.ui.modules.repos.issues.issue.details.IssuePagerMvp;
import com.infostretch.android.core.AutomationCore;
import com.infostretch.android.utils.LocatorUtils;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.PreferenceMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

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
    public static void clearText(String loc){
        getElement(loc).perform(ViewActions.clearText());
    }

    public static void TypeText(String loc ,String text){
        getElement(loc).perform(ViewActions.typeText(text));
    }

    public static void DoubleClick(String loc){
        getElement(loc).perform(ViewActions.doubleClick());
    }

    public static void LongClick(String loc){
        getElement(loc).perform(ViewActions.longClick());
    }


    public static void ScrollTo(String loc){
        getElement(loc).perform(ViewActions.scrollTo());
    }

    public static void OpenLinkWithText(String loc ,String linkText){
        getElement(loc).perform(ViewActions.openLinkWithText(linkText));
    }

    public static void OpenLinkWithURI(String loc,String uri){
        getElement(loc).perform(ViewActions.openLinkWithUri(uri));
    }

    public static void ReplaceText(String loc,String text){
        getElement(loc).perform(ViewActions.replaceText(text));
    }

    public static void IsEnabled(String loc){
        getElement(loc).check(matches(ViewMatchers.isEnabled()));
    }

    public static void IsDisplayed(String loc){
        getElement(loc).check(matches(isDisplayed()));
    }

    public static void IsChecked(String loc){
        getElement(loc).check(matches(ViewMatchers.isChecked()));
    }

    public static void IsNotChecked(String loc){
        getElement(loc).check(matches(ViewMatchers.isNotChecked()));
    }

    public static void IsSelected(String loc){
        getElement(loc).check(matches(ViewMatchers.isSelected()));
    }

    public static void HasContentDescription(String loc){
        getElement(loc).check(matches(ViewMatchers.hasContentDescription()));
    }

    public static void WithContentDescription(String loc,String text){
        getElement(loc).check(matches(ViewMatchers.withContentDescription(text)));
    }

    public static void WithHint(String loc,String hintText){
        getElement(loc).check(matches(ViewMatchers.withHint(hintText)));
    }

    public static void WithText(String loc, String text){
        getElement(loc).check(matches(ViewMatchers.withText(text)));
    }

    public static void WithID(String loc ,int id){
        getElement(loc).check(matches(withId(id)));
    }

    public static void WithClassName(String loc ,Matcher<String> stringMatcher){
        getElement(loc).check(matches(ViewMatchers.withClassName(stringMatcher)));
    }
    public static void ClickOnRecyclerViewChild(String recycleIdName ,int pos){

        onView(allOf(withId(getResourceId(recycleIdName)),isDisplayed(),withChild(withClassName(endsWith("RelativeLayout"))))).perform(RecyclerViewActions.actionOnItemAtPosition(pos,ViewActions.click()));
    }


    public static void WithTagKey(String loc ,int id){
        getElement(loc).check(matches(ViewMatchers.withTagKey(id)));
    }
    public static void WithTagValue(String loc , Matcher<Object> objectMatcher ){
        getElement(loc).check(matches(ViewMatchers.withTagValue(objectMatcher)));
    }
    public static int getResourceId(String s) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(s, "id", packageName);
    }
    public static ViewInteraction getElement(String loc){
        return LocatorUtils.getViewLocator(loc);
    }

}






