package com.intellibitz.muthuselvam.androidapplication;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

/**
 */
public class MainApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
//        if multidex super will take care of multidex install
        super.attachBaseContext(base);
//        if the application does not extend MultiDex, then install here
        if (!MultiDexApplication.class.isInstance(this)) {
            MultiDex.install(this);
        }
    }
}
