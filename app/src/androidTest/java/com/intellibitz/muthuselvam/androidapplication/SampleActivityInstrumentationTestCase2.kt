/*
* Copyright (C) 2013 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellibitz.muthuselvam.androidapplication;

import android.test.ActivityInstrumentationTestCase2;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for Instrumentation.
 */
@RunWith(AndroidJUnit4.class)
public class SampleActivityInstrumentationTestCase2 extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mTestActivity;

    public SampleActivityInstrumentationTestCase2() {
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
        super.setUp();

        mTestActivity = getActivity();
    }

    /**
     * Add more tests below.
     */
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //Try to add a message to add context to your assertions. These messages will be shown if
        //a tests fails and make it easy to understand why a test failed
        mTestActivity = getActivity();
        assertNotNull("mTestActivity is null", mTestActivity);
    }

    @Test
    public void testMe() {
        assertTrue(true);
    }

}
