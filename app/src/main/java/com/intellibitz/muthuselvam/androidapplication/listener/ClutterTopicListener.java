package com.intellibitz.muthuselvam.androidapplication.listener;


import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;
import com.intellibitz.muthuselvam.androidapplication.data.MessageItem;

/**
 */
public interface ClutterTopicListener extends
        ClutterListener {
    void onClutterTopicClicked(MessageItem item, ContactItem user);

    void onClutterTopicsLoaded(int count);
}
