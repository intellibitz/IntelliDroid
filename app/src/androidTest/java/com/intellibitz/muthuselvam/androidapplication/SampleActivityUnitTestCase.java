package com.intellibitz.muthuselvam.androidapplication;

import android.test.ActivityUnitTestCase;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class SampleActivityUnitTestCase extends ActivityUnitTestCase<MainActivity> {

    public SampleActivityUnitTestCase() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {

        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        // Starts the activity under test using the default Intent with:
        // action = {@link Intent#ACTION_MAIN}
        // flags = {@link Intent#FLAG_ACTIVITY_NEW_TASK}
        // All other fields are null or empty.
//        mTestActivity = getActivity();
        super.setUp();
    }

    /**
     * Add more tests below.
     */
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
//        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        //Try to add a message to add context to your assertions. These messages will be shown if
        //a tests fails and make it easy to understand why a test failed
        assertNotNull("mTestActivity is null", getInstrumentation());
    }


}
