package com.example.marvin.familylink._UI;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by marvin on 16/7/2.
 */
public class FamiApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
