package com.intellibitz.muthuselvam.androidapplication.listener;


import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;

/**
 */
public interface DeviceContactTopicListener extends
        ContactListener {
    void onDeviceContactTopicClicked(ContactItem item, ContactItem user);

    void onDeviceContactTopicsLoaded(int count);
}
