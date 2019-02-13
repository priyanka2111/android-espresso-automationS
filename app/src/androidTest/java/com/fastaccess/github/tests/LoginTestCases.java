package com.fastaccess.github.tests;

import com.infostretch.android.core.BaseTestCase;
import static com.fastaccess.github.steps.LoginSteps.*;
import static com.fastaccess.github.steps.UserHomePageSteps.verifyOnHomePage;

import org.junit.Test;

public class LoginTestCases extends BaseTestCase {

    @Test
    public void validLogin() throws NoSuchFieldException {
        openApp();
        loginWithBasicAuth("username","password");
        verifyOnHomePage();

    }
}
