package com.hexs.learnactivitydemo.basicstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hexs.learnactivitydemo.R;

public class CActivity extends AppCompatActivity implements View.OnClickListener {

    public static String ACTION = "com.hexs.learnactivitydemo.intent.action.BActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        findViewById(R.id.btnClick).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("data", "这是CActivity返回的数据");
        setResult(200, intent);
        finish();
    }
}
