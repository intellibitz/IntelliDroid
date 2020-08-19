package com.intellibitz.muthuselvam.androidapplication;

import android.content.Intent;
import android.os.IBinder;
import android.test.ServiceTestCase;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ServiceTestRule;
import com.intellibitz.muthuselvam.androidapplication.service.ChatService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

/**
 * Created by muthuselvam on 17-02-2016.
 */
@RunWith(AndroidJUnit4.class)
public class SampleServiceTestCase extends ServiceTestCase<ChatService> {

    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    public SampleServiceTestCase() {
        super(ChatService.class);
    }

    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();

    }

    @Test
    public void testWithBoundService() throws TimeoutException {
        // Create the service Intent.
        Intent serviceIntent =
                new Intent(InstrumentationRegistry.getTargetContext(),
                        ChatService.class);

        // Data can be passed to the service via the Intent.
        serviceIntent.putExtra("key", 42L);

//        the binder must be implemented on the service for the following to work
        // Bind the service and grab a reference to the binder.
        IBinder binder = mServiceRule.bindService(serviceIntent);

        assertNotNull(binder);

        // Get the reference to the service, or you can call
        // public methods on the binder directly.
//        ChatService service = (binder).getService();

        // Verify that the service is working correctly.
//        assertNotNull(service);
//        assertThat(service.getRandomInt(), is(any(Integer.class)));
    }
}
