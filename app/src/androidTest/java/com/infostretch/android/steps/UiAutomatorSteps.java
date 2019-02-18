package com.infostretch.android.steps;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;
import android.widget.Toast;
import com.infostretch.android.core.AutomationCore;
import com.infostretch.android.core.NoSuchElementFoundException;
import com.infostretch.android.utils.LocatorUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;



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

    public static void clickAndWaitForNewWindowAppears(String loc) {
        clickAndWaitForNewWindowAppears(loc, 5000);
    }

    public static void clickAndWaitForNewWindowAppears(String loc, long timeout) {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.clickAndWait(Until.newWindow(), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementTextContains(String loc, String text) {

        elementTextContains(loc, text, 5000);

    }

    public static void elementTextContains(String loc, String text, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.textContains(text), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeFocused(String loc) {
        try {
            elementToBeFocused(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeFocused(String loc, long timeout) {


        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.focused(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void elementToBeGone(String loc) {

        try {
            elementToBeGone(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeGone(String loc, long timeout) {


        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.enabled(true), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeFocusable(String loc) {


        try {
            elementToBeFocusable(loc, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void elementToBeFocusable(String loc, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.focusable(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void textToBePresentInElement(String loc, String text) {


        try {
            textToBePresentInElement(loc, text, 5000);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void textToBePresentInElement(String loc, String text, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.textEquals(text), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void elementToBeEnable(String loc) {

        try {
            elementToBeEnable(loc, 5000);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeEnable(String loc, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.enabled(true), timeout);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeClickable(String loc) {

        try {
            elementToBeClickable(loc, 5000);

        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void elementToBeClickable(String loc, long timeout) {

        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            uiObject2.wait(Until.clickable(true), timeout);


        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void presenceOfElementLocated(String loc) {
        presenceOfElementLocated(loc, 5000);
    }

    public static void presenceOfElementLocated(String loc, long timeout) {

        try {
            BySelector byselector = getBySelector(loc);
            AutomationCore.getInstance().getUiDevice().wait(Until.hasObject(byselector), timeout);
        } catch (Exception e) {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public static void verifyTextPresent(String loc, String message, String text)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            MatcherAssert.assertThat(message,uiObject2.getText().toString(),equalTo(text));
        }
        catch(Exception e)
        {
          Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void verifyIsEnabled(String loc, String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isEnabled());
        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public static void verifyIsClickable(String loc,String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isClickable());
        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void verifyIsScrollable(String loc,String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isScrollable());
        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void verifyIsCheckable(String loc,String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isCheckable());
        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void verifyIsChecked(String loc,String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isChecked());
        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void verifyIsLongClickable(String loc,String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isLongClickable());
        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void verifyIsFocusable(String loc,String message)
    {
        try {
            uiObject2 = AutomationCore.getInstance().getUiDevice().findObject(getBySelector(loc));
            Assert.assertTrue(message,uiObject2.isFocusable());

        }
        catch(Exception e)
        {
            Toast.makeText(AutomationCore.getInstance().getTargetContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
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
