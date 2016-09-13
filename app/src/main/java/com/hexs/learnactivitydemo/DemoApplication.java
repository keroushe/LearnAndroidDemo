package com.hexs.learnactivitydemo;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by hexs on 16/9/13.
 */
public class DemoApplication extends Application {

    private static final String TAG = "DemoApplication";

    private String username = null;
    private String password = null;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "----onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "----onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "----onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i(TAG, "----onTerminate");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG, "----onTrimMemory");
    }
}
