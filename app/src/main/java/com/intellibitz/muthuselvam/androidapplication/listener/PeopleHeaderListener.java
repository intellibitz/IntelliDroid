package com.intellibitz.muthuselvam.androidapplication.listener;


import com.intellibitz.muthuselvam.androidapplication.data.MessageItem;

/**
 */
public interface PeopleHeaderListener extends
        PeopleListener {
    void onPeopleHeaderChanged(MessageItem messageItem);
}
