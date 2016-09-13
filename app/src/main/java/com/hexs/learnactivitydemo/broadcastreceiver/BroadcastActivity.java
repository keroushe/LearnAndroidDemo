package com.hexs.learnactivitydemo.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.hexs.learnactivitydemo.R;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private SecondReceiver secondReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        editText = (EditText)findViewById(R.id.edittext);

        findViewById(R.id.btnregist).setOnClickListener(this);
        findViewById(R.id.btnunregist).setOnClickListener(this);
        findViewById(R.id.btnsend).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnregist:{
                if (secondReceiver == null) {
                    secondReceiver = new SecondReceiver();
                    registerReceiver(secondReceiver, new IntentFilter(SecondReceiver.ACTION));
                }
                break;
            }
            case R.id.btnunregist:{
                if (secondReceiver != null) {
                    unregisterReceiver(secondReceiver);
                    secondReceiver = null;
                }
                break;
            }
            case R.id.btnsend:{
                // 静态注册,发送数据
                //Intent intent = new Intent(BroadcastActivity.this, FirstReceiver.class);
                // 动态注册,发送数据
                //Intent intent = new Intent(SecondReceiver.ACTION);
                //intent.putExtra("data", editText.getText().toString());
                //sendBroadcast(intent);
                // 群发数据
                Intent intent = new Intent("com.hexs.learnactivitydemo.intent.action.broadcastreceiver");
                intent.putExtra("data", editText.getText().toString());
                // 发送有序广播, 能够中途中断传播
                sendOrderedBroadcast(intent, null);
                break;
            }
        }
    }
}
