package com.intellibitz.muthuselvam.androidapplication.listener;


import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;
import com.intellibitz.muthuselvam.androidapplication.data.MessageItem;

/**
 */
public interface PeopleTopicListener extends
        PeopleListener {
    void onPeopleTopicClicked(MessageItem item, ContactItem user);

    void onPeopleTopicsLoaded(int count);
}
