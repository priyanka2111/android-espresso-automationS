package com.infostretch.android.steps;

import android.content.Intent;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Until;

import static com.infostretch.android.core.AutomationCore.getInstance;

public class ActivitySteps {

    public static void startActivity(Intent intent){
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        getInstance().getInstrumentation().getContext().startActivity(intent);
    }
}
