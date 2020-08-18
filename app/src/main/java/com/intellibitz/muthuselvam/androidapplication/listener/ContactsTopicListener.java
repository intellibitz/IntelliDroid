package com.intellibitz.muthuselvam.androidapplication.listener;

import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;

/**
 */
public interface ContactsTopicListener extends
        ContactListener {
    void onContactsTopicClicked(ContactItem item, ContactItem user);

    void onContactsTopicsLoaded(int count);
}
