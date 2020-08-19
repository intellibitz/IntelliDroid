package com.intellibitz.muthuselvam.androidapplication;

import android.os.Bundle;

import com.intellibitz.muthuselvam.androidapplication.data.BaseItem;
import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IntellibitzUserActivity extends
        IntellibitzPermissionActivity {
    protected ContactItem user;
    private Set<BaseItemListener> baseItemListeners =
            Collections.synchronizedSet(new HashSet<BaseItemListener>());

    public void setUser(ContactItem user) {
        this.user = user;
    }

    public void addBaseItemListener(BaseItemListener listener) {
        baseItemListeners.add(listener);
    }

    private void notifyBaseItemListeners(String key, BaseItem value) {
        for (BaseItemListener baseItemListener : baseItemListeners) {
            baseItemListener.onBaseItemStateChanged(key, value);
        }
    }

    public void notifyUserBaseItemListeners() {
        notifyBaseItemListeners(ContactItem.USER_CONTACT, user);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        user = savedInstanceState.getParcelable(ContactItem.USER_CONTACT);
        notifyUserBaseItemListeners();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(ContactItem.USER_CONTACT, user);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface BaseItemListener {
        void onBaseItemStateChanged(String key, BaseItem value);
    }
}
