package com.hexs.learnactivitydemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by hexs on 16/9/13.
 */
public class SecondReceiver extends BroadcastReceiver {

    public static final String ACTION = "com.hexs.learnactivitydemo.intent.action.broadcastreceiver.BroadcastReceiver";

    private static final String TAG = "SecondReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("data");
        Log.i(TAG, "----接收到广播消息: data = " + data);
    }
}
