package com.intellibitz.muthuselvam.androidapplication.test;

import android.os.Bundle;
import androidx.multidex.MultiDex;
import androidx.test.runner.AndroidJUnitRunner;

public class MultiDexTestRunner extends AndroidJUnitRunner {
    public MultiDexTestRunner() {
    }

    @Override
    public void onCreate(Bundle arguments) {
        MultiDex.install(getTargetContext());
        super.onCreate(arguments);
    }
}