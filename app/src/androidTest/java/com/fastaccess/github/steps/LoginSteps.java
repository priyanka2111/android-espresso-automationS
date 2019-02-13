package com.fastaccess.github.steps;
import android.util.Log;

import com.fastaccess.github.debug.test.R;
import com.infostretch.android.steps.ApplicationSteps;
import com.infostretch.android.steps.EspressoSteps;

import java.lang.reflect.Field;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LoginSteps {

    public static void openApp(){
        ApplicationSteps.startApp();
    }
    public static void loginWithBasicAuth(String username, String password) throws NoSuchFieldException {

        EspressoSteps.click(R.string.login_basic_auth_btn_loc);
        login(username,password);
    }
    public static void login(String username, String password){
        EspressoSteps.sendKeys(R.string.login_username_loc,username,true);
        EspressoSteps.sendKeys(R.string.login_password_loc,password,true);
        EspressoSteps.click(R.string.login_submit_btn_loc);
    }
}
