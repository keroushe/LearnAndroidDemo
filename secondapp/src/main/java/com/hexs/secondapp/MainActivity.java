package com.hexs.secondapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hexs.learnactivitydemo.service.IMyAidlBinder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    //夸应用只能以这种方式启动:ComponentName(组件名):通过包名+类名,注意包名是工程包名,类名需要全路径
                    ComponentName componentName = new ComponentName("com.hexs.learnactivitydemo","com.hexs.learnactivitydemo.service.MyService");
                    Intent intent = new Intent();
                    intent.setComponent(componentName);

                    intent.putExtra("data","App2数据传给service");
                    startService(intent);
                    break;
                }
                case R.id.btnstopService:{
                    ComponentName componentName = new ComponentName("com.hexs.learnactivitydemo","com.hexs.learnactivitydemo.service.MyService");
                    Intent intent = new Intent();
                    intent.setComponent(componentName);

                    stopService(intent);
                    break;
                }
                case R.id.btnbindService:{
                    ComponentName componentName = new ComponentName("com.hexs.learnactivitydemo","com.hexs.learnactivitydemo.service.ServiceForExternalApp");
                    Intent intent = new Intent();
                    intent.setComponent(componentName);

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
            IMyAidlBinder binder = IMyAidlBinder.Stub.asInterface(service);
            try {
                binder.setnum(100);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "----服务解绑成功");
        }
    };
}
