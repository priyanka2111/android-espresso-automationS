package com.infostretch.android.core;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

public class AutomationCore {

    private static AutomationCore instance;
    UiDevice uiDevice;

    private AutomationCore(){
       init();
    }

    private void init(){
        uiDevice =  UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    public UiDevice getUiDevice() {
        //return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        return uiDevice;
    }

    public static AutomationCore getInstance() {
        if(instance==null){
            instance = new AutomationCore();
        }
        return instance;
    }
    public Instrumentation getInstrumentation(){
        return InstrumentationRegistry.getInstrumentation();
    }
    public Context getTargetContext(){
        return InstrumentationRegistry.getTargetContext();
    }
}
