package com.intellibitz.muthuselvam.androidapplication.listener;


import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;

/**
 */
public interface IntellibitzContactTopicListener extends
        ContactListener {
    void onIntellibitzContactTopicClicked(ContactItem item, ContactItem user);

    void onIntellibitzContactTopicsLoaded(int count);
}
