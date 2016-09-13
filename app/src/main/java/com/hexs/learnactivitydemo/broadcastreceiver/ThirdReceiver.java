package com.hexs.learnactivitydemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ThirdReceiver extends BroadcastReceiver {

    private static final String TAG = "ThirdReceiver";

    public ThirdReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("data");
        Log.i(TAG, "----接收到广播消息: data = " + data);

        // 中断传播,FirstReceiver接收不到了
        abortBroadcast();
    }
}
