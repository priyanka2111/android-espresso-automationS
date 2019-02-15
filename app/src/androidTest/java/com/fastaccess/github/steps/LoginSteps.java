package com.fastaccess.github.steps;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.infostretch.android.steps.ApplicationSteps;
import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.steps.UiAutomatorSteps;

public class LoginSteps {

    public static void openApp(){
        ApplicationSteps.startApp();
    }
    public static void loginWithBasicAuth(String username, String password){
        EspressoSteps.click("login.basic.auth.btn.loc");
        login(username,password);
    }
    public static void login(String username, String password){
        EspressoSteps.sendKeys("login.username.loc",username,true);
        EspressoSteps.sendKeys("login.password.loc",password,true);
        EspressoSteps.click("login.submit.btn.loc");
    }
//    public static void clickMenu()
//    {
//        EspressoSteps.click("login.menu.btn.loc");
//    }

    public static void UIloginWithBasicAuth(String username, String password){
        UiAutomatorSteps.click("login.ui.basic.auth.txt.btn.loc");
        UiLogin(username,password);
    }

    public static void UiLogin(String username, String password)
    {
        UiAutomatorSteps.sendKeys("login.ui.username.loc",username,true);
        UiAutomatorSteps.sendKeys("login.ui.password.loc",password,true);
        UiAutomatorSteps.click("login.ui.submit.btn.loc");
    }

    public static void UiClickMenu() throws UiObjectNotFoundException {
        UiAutomatorSteps.click("home.ui.menu.drawer.loc");
    }
}
