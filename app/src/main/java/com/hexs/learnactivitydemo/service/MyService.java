package com.hexs.learnactivitydemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by hexs on 16/9/13.
 */
public class MyService extends Service {

    public static final String ACTION = "com.hexs.learnactivitydemo.intent.action.MyService";

    private static final String TAG = "MyService";
    private static volatile boolean isStop = false;

    private int num = 0;
    private MyBinder binder = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "----onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        runTask();
        String data = intent.getStringExtra("data");
        Log.i(TAG, "----onStartCommand:接收到activity传来的数据=" + data);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        runTask();
        Log.i(TAG, "----onBind");
        binder = new MyBinder();
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "----onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        stopTask();
        Log.i(TAG, "----onDestroy");
        super.onDestroy();
    }

    private void runTask() {
        isStop = false;
        num = 0;
        new MyThread().start();
    }

    private void stopTask() {
        isStop = true;
    }

    private class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (!isStop) {
                Log.i(TAG, "----服务正在运行,num = " + ++num);
                MyServiceListener listener;
                if (binder != null && (listener = binder.getServiceListener()) != null) {
                    listener.dataChange("回传数据给activity,num = " + num);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class MyBinder extends Binder {

        private MyServiceListener serviceListener = null;

        public void setServiceListener(MyServiceListener serviceListener) {
            this.serviceListener = serviceListener;
        }

        public MyServiceListener getServiceListener() {
            return serviceListener;
        }

        public void setnum(int _num) {
            num = _num;
        }
    }

    public interface MyServiceListener {
        public void dataChange(String data);
        public void dataChange(Bundle bundle);
    }

    /*
    运行日志:
    com.hexs.learnactivitydemo I/MyService: ----onCreate
    com.hexs.learnactivitydemo I/MyService: ----onStartCommand
    com.hexs.learnactivitydemo I/MyService: ----服务正在运行
    com.hexs.learnactivitydemo I/MyService: ----服务正在运行
    com.hexs.learnactivitydemo I/MyService: ----onDestroy
    com.hexs.learnactivitydemo I/MyService: ----onCreate
    com.hexs.learnactivitydemo I/MyService: ----onBind
    com.hexs.learnactivitydemo I/MyService: ----服务正在运行
    com.hexs.learnactivitydemo I/MyService: ----服务正在运行
    com.hexs.learnactivitydemo I/MyService: ----onUnbind
    com.hexs.learnactivitydemo I/MyService: ----onDestroy
     */
}
