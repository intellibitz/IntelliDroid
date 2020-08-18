package com.intellibitz.muthuselvam.androidapplication.listener;


import com.intellibitz.muthuselvam.androidapplication.data.ContactItem;

import java.io.File;

/**
 */
public interface ProfileTopicListener extends
        ProfileListener {
    // TODO: Update argument type and nameParam
    void onProfilePicChanged(File file);

    void onProfileTopicClicked(ContactItem item);

    void onProfileTopicsLoaded(int count);
}
