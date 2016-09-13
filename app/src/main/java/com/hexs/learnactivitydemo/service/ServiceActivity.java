package com.hexs.learnactivitydemo.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hexs.learnactivitydemo.R;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.btnstartService).setOnClickListener(listener);
        findViewById(R.id.btnstopService).setOnClickListener(listener);
        findViewById(R.id.btnbindService).setOnClickListener(listener);
        findViewById(R.id.btnunbindService).setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnstartService:{
                    //1. 显示Intent
                    //Intent intent = new Intent(ServiceActivity.this, MyService.class);
                    //2. ACTION
                    //Intent intent = new Intent(MyService.ACTION);
                    //3. ComponentName(组件名):通过包名+类名,注意包名是工程包名,类名需要全路径
                    ComponentName componentName = new ComponentName("com.hexs.learnactivitydemo","com.hexs.learnactivitydemo.service.MyService");
                    Intent intent = new Intent();
                    intent.setComponent(componentName);

                    intent.putExtra("data","数据传给service");
                    startService(intent);
                    break;
                }
                case R.id.btnstopService:{
                    Intent intent = new Intent(MyService.ACTION);
                    stopService(intent);
                    break;
                }
                case R.id.btnbindService:{
                    Intent intent = new Intent(MyService.ACTION);
                    bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                    break;
                }
                case R.id.btnunbindService:{
                    unbindService(serviceConnection);
                    break;
                }
            }
        }
    };

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "----服务绑定成功");
            MyService.MyBinder binder = (MyService.MyBinder)service;
            binder.setnum(100);
            binder.setServiceListener(serviceListener);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "----服务解绑成功");
        }
    };

    private MyService.MyServiceListener serviceListener = new MyService.MyServiceListener() {
        @Override
        public void dataChange(String data) {
            Log.i(TAG, "----接收到服务回传数据:data = " + data);
        }

        @Override
        public void dataChange(Bundle bundle) {
            Log.i(TAG, "----接收到服务回传数据:bundle = " + bundle);
        }
    };
}
