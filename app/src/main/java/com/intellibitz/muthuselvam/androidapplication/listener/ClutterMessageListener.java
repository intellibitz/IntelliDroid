package com.intellibitz.muthuselvam.androidapplication.listener;

/**
 */
public interface ClutterMessageListener extends
        ClutterListener {
    void onEmailMessageTyping(String text);

    void onEmailMessageTypingStopped(String text);
}
