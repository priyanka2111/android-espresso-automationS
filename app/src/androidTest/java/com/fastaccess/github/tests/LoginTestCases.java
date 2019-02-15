package com.fastaccess.github.tests;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.infostretch.android.core.BaseTestCase;

import org.junit.Test;

import static com.fastaccess.github.steps.LoginSteps.UIloginWithBasicAuth;
import static com.fastaccess.github.steps.LoginSteps.loginWithBasicAuth;
import static com.fastaccess.github.steps.LoginSteps.openApp;
import static com.fastaccess.github.steps.UserHomePageSteps.verifyOnHomePage;

public class LoginTestCases extends BaseTestCase {

    @Test
    public void validLogin() throws NoSuchFieldException, UiObjectNotFoundException {
        openApp();
        loginWithBasicAuth("keval00","Omgpassword007");
        verifyOnHomePage();
    }

    @Test
    public void validLoginWithUi() throws NoSuchFieldException, UiObjectNotFoundException {
        openApp();
        UIloginWithBasicAuth("keval00","Omgpassword007");
        verifyOnHomePage();
       // UiClickMenu();
    }

}
