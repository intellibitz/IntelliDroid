package com.intellibitz.muthuselvam.androidapplication.listener;

import com.intellibitz.muthuselvam.androidapplication.data.MessageItem;

/**
 */
public interface ClutterMessageHeaderListener extends
        ClutterListener {
    void onEmailMessageHeaderChanged(MessageItem messageItem);
}
