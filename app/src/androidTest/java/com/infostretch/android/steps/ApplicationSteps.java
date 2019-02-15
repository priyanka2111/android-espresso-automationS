package com.infostretch.android.steps;

import android.content.Context;
import android.content.Intent;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import static com.infostretch.android.core.AutomationCore.getInstance;

public class ApplicationSteps {

    public static void startApp() {
        startApp(true);
    }

    public static UiDevice getmDevice() {
        return mDevice;
    }

    static UiDevice mDevice;

    public static void startApp(boolean waitForApp) {
        mDevice = getInstance().getUiDevice();
        String pkgName = getInstance().getTargetContext().getPackageName();
        final String launcherPackage = mDevice.getLauncherPackageName();
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                30000);
        Context context = getInstance().getInstrumentation().getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(pkgName);
        ActivitySteps.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(pkgName).depth(0)),
                30000);
    }

    public static void closeApp() {

    }

    public static void clearApp() {

    }

    public static void uninstallApp() {

    }
}
