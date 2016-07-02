package com.example.marvin.familylink._UI._Utils;

import android.content.SharedPreferences;

/**
 * Created by marvin on 15/7/10.
 */
public class Constants {
    // App Id 和 APP Key
    public final static String APP_ID = "9qfq21ze24as7sc44g9by1pwqho3ikzw0u99gkxorwefvc8r";
    public final static String APP_KEY = "h75or0a7xc35x8dr78z8tdlqd0hzvejxeasodtpq3fzwwn4m";

    public static String INSTALLATION_ID = null;

    // Fragment Name
    public final static String FAMILY_FRAGMENT = "Family";
    public final static String MINE_FRAGMENT = "Mine";

    // Class Info
    public final static String TASK = "Task";
    public final static String UNREPLIED_TASK = "unreplied";
    public final static String SENT_TASK = "sent";

    public final static String ANSWER = "Answer";
    public final static String MESSAGE = "Message";

    // Cache KEY
    public final static String MESSAGE_MEMORY_KEY = "messageKey";
    public final static String FRIEND_MEMORY_KEY = "friendKey";
    public final static String UNREPLIED_TASK_MEMORY_KEY = "unrepliedTaskKey";
    public final static String SENT_TASK_MEMORY_KEY = "sentTaskKey";
    public final static String RECOMMEND_FRIEND_MEMORY_KEY = "recommendFriendKey";
    public final static String CONTACT_MEMORY_KEY = "contactKey";
    public final static String SENDING_REQUEST_KEY = "sendingRequestKey";
    public final static String RECEIVING_REQUEST_KEY = "receivingRequestKey";

    // Personal Sculpture
    public final static String SCULPTURE = "sculpture";

    // SP
    public static SharedPreferences SP;
    public static SharedPreferences.Editor EDITOR;
    public final static String SHARED_PREF_NAME = "somethingUnique";
    public final static String USER_FIRST_LOGIN = "isUserFirstLogin";
    public final static String USER_INSTALLATION = "installationId";

    /*   Friend   */

    // Friend Event Key
    public final static String EVENT_TYPE = "type";
    public final static String EVENT_NEW_FRIEND = "new_friend";
    public final static String EVENT_REQUEST = "request";
    public final static String EVENT_ACCPET = "accept";
    public final static String EVENT_CONNECT = "connect";
    public final static String EVENT_SENT = "sent";

    // Friend Info Key
    public final static String FRIENDINFO_ID = "id";
    public final static String FRIENDINFO_USERNAME= "userName";
    public final static String FRIENDINFO_PHONE = "userPhone";
    public final static String FRIENDINFO_EMAIL = "userEmail";


    /*   Notification   */

    // Notification
    public final static String PUSH_ACTION = "com.yochat.push";
    public final static String PUSH_DATA = "com.avos.avoscloud.Data";
    public final static String PUSH_DATA_CONTENT = "content";
    public final static int NOTIFICATION_ID = 0;

    public final static String NOTIFICATION_TYPE = "type";
    public final static String TASK_CREATION = "task_creation";
    public final static String TASK_COMPLETION = "task_completion";
    public final static String FRIEND_REQUEST = "friend_request";
    public final static String FRIEND_ACCPET = "friend_acception";


}
