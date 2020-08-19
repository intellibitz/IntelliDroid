package com.intellibitz.muthuselvam.androidapplication;

import android.database.sqlite.SQLiteDatabase;
import android.test.ProviderTestCase2;
import android.test.mock.MockContentResolver;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.intellibitz.muthuselvam.androidapplication.content.UserContentProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SampleProviderTestCase2 extends ProviderTestCase2<UserContentProvider> {

    // Contains a reference to the mocked content resolver for the provider under test.
    private MockContentResolver mMockResolver;
    // Contains an SQLite database, used as test data
    private SQLiteDatabase mDb;


    /**
     * Constructor.
     *
     * @ The class name of the provider under test
     * @ The provider's authority string
     */
    public SampleProviderTestCase2() {
        super(UserContentProvider.class, UserContentProvider.AUTHORITY);
    }

    /*
     * Sets up the test environment before each test method. Creates a mock content resolver,
     * gets the provider under test, and creates a new database for the provider.
     */
    @Override
    protected void setUp() throws Exception {
//        setContext(InstrumentationRegistry.getInstrumentation().getTargetContext());
        // Calls the base class implementation of this method.
        super.setUp();

        // Gets the resolver for this test.
        mMockResolver = getMockContentResolver();

        /*
         * Gets a handle to the database underlying the provider. Gets the provider instance
         * created in super.setUp(), gets the DatabaseOpenHelper for the provider, and gets
         * a database object from the helper.
         */
        mDb = getProvider().getOpenHelperForTest().getWritableDatabase();
    }

    /*
     *  This method is called after each test method, to clean up the current fixture. Since
     *  this sample test case runs in an isolated context, no cleanup is necessary.
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    @Test
    public void testProviders() {
        assert mMockResolver != null;
        assert mDb != null;
    }
}
