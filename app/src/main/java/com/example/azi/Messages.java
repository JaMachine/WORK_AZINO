package com.example.azi;

import android.app.Application;

import com.onesignal.OneSignal;

public class Messages extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId("3ee77eaf-e3f6-44c9-9c88-c97136720011");
    }
}