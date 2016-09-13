package com.hexs.learnactivitydemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FirstReceiver extends BroadcastReceiver {

    private static final String TAG = "FirstReceiver";

    public FirstReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("data");
        Log.i(TAG, "----接收到广播消息: data = " + data);
    }
}
