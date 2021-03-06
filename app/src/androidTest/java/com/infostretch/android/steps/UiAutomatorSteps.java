package com.infostretch.android.steps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.widget.Toast;

import com.infostretch.android.core.AutomationCore;
import com.infostretch.android.exceptions.NoSuchElementFoundException;
import com.infostretch.android.utils.LocatorUtils;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.xml.sax.Locator;


import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class UiAutomatorSteps {

    private static UiObject2 uiObject2;

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

    public static void waitForElementToBeChecked(String loc) {
        try {
            waitForElementToBeChecked(loc, 5000);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public static void waitForElementToBeChecked(String loc, long timeout) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.checked(true), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeCheckable(String loc) {
        try {
            waitForElementToBeCheckable(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeCheckable(String loc, long timeout) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.checkable(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void clickAndWaitForScrollFinished(String loc, String direction) {
        try {
            clickAndWaitForScrollFinished(loc, direction, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void clickAndWaitForScrollFinished(String loc, String direction, long timeout) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.clickAndWait(Until.scrollFinished(Direction.valueOf(direction)), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void clickAndWaitForNewWindowAppears(String loc) {
        try {
            clickAndWaitForNewWindowAppears(loc, 5000);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void clickAndWaitForNewWindowAppears(String loc, long timeout) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.clickAndWait(Until.newWindow(), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementTextContains(String loc, String text) {

        try {
            waitForElementTextContains(loc, text, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    public static void waitForElementTextContains(String loc, String text, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.textContains(text), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeFocused(String loc) {
        try {
            waitForElementToBeFocused(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeFocused(String loc, long timeout) {


        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.focused(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void waitForElementToBeGone(String loc) {

        try {
            waitForElementToBeGone(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeGone(String loc, long timeout) {


        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.enabled(true), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeFocusable(String loc) {


        try {
            waitForElementToBeFocusable(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void waitForElementToBeFocusable(String loc, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.focusable(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForTextToBePresent(String loc, String text) {


        try {
            waitForTextToBePresent(loc, text, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForTextToBePresent(String loc, String text, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.textEquals(text), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void waitForElementToBeEnable(String loc) {

        try {
            waitForElementToBeEnable(loc, 5000);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeEnable(String loc, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.enabled(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeClickable(String loc) {

        try {
            waitForElementToBeClickable(loc, 5000);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBeClickable(String loc, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.clickable(true), timeout);


        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void waitForElementToBePresent(String loc) {
        waitForElementToBePresent(loc, 5000);
    }

    public static void waitForElementToBePresent(String loc, long timeout) {

        try {
            BySelector byselector = getBySelector(loc);
            AutomationCore.getInstance().getUiDevice().wait(Until.hasObject(byselector), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void verifyTextPresent(String loc, String message, String text) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            MatcherAssert.assertThat(message, uiObject2.getText().toString(), equalTo(text));
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsEnabled(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isEnabled());
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsClickable(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isClickable());
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsScrollable(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isScrollable());
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsCheckable(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isCheckable());
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsChecked(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isChecked());
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsLongClickable(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isLongClickable());
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Scroll Horizontally Until View Found
     */
    public static void scrollHorizontal(String loc){
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.setAsHorizontalList();
        try {
            appViews.scrollIntoView(getUiSelector(loc));
//            AutomationCore.getInstance().getUiDevice().findObject(new UiSelector().text("GISTS")).click();

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void scrollVertical(String loc){
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.setAsVerticalList();
        try {
            appViews.scrollIntoView(getUiSelector(loc));
//            AutomationCore.getInstance().getUiDevice().findObject(new UiSelector().text("GISTS")).click();

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void verifyIsFocusable(String loc, String message) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message, uiObject2.isFocusable());

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    //-->code to get byselector
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
    // Code to Byselector ends here


    //--> Code to get UiSelector
    public static UiSelector getUiSelector(String loc) throws Exception {
        Context context = AutomationCore.getInstance().getInstrumentation().getContext();
        Resources resources = context.getResources();
        int id = resources.getIdentifier(loc, "string", context.getPackageName());
        String value = resources.getString(id);
        String[] arrOfValue = value.split("=", 2);
        String prefix = arrOfValue[0];
        String suffix = arrOfValue[1];
        return getUiSelector(prefix, suffix);
    }

    private static UiSelector getUiSelector(String strategy, String text) throws Exception {

        String s = strategy.toUpperCase();
        ;
        switch (s) {
            case "CLASSNAME":
                return new UiSelector().className(text);

            case "TEXT":
                return new UiSelector().text(text);

            case "ID":
                return new UiSelector().resourceId(text);

            case "ACCESSIBILITY_ID":
                return new UiSelector().descriptionMatches(text);

        }
        return null;
    }
    // code to get UiSelector ends here...

    public static UiObject getUIElement(String loc) {
        return LocatorUtils.getUIViewLocator(loc);
    }

    public static List<UiObject2> getUIElements(String loc){return LocatorUtils.getUIViewsLocator(loc);}
}
