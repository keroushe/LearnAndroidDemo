package com.hexs.learnactivitydemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ServiceForExternalApp extends Service {

    private static final String TAG = "ServiceForExternalApp";
    private static volatile boolean isStop = false;

    private int num = 0;

    public ServiceForExternalApp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "----onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "----onBind");
        runTask();
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

    private IMyAidlBinder.Stub binder = new IMyAidlBinder.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setnum(int _num) throws RemoteException {
            num = _num;
        }
    };

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
                // "回传数据给activity,num = " + num
                // 跨进程之间可以将数据传给外部服务,但是外部服务数据无法回调.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
