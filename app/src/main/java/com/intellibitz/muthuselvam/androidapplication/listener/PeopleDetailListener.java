package com.intellibitz.muthuselvam.androidapplication.listener;

/**
 */
public interface PeopleDetailListener extends
        PeopleListener {
    void onPeopleTyping(String text);

    void onPeopleTypingStopped(String text);
}
