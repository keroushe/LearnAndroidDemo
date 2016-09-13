package com.hexs.learnactivitydemo.lanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hexs.learnactivitydemo.R;

public class LanuchFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuch_first);


        findViewById(R.id.btnJump1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchFirstActivity.this, LanuchFirstActivity.class));
            }
        });

        findViewById(R.id.btnJump2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchFirstActivity.this, LanuchSecondActivity.class));
            }
        });

    }

    /*
    启动模式总结:
    对于被设置的Activity而言
    standard: 每次启动Activity都会重新创建
    singleTop: 如果当前Activity位于栈顶,则不会创建新的Activity,否则就会创建.
    singleTask: 如果当前Activity存在于栈中,则会直接把该位置上的所有Activity全部弹出.
    singleInstance: 如果当前Activity被设置为singleInstance,则在其基础上启动的每一个Activity会被单独放入一个栈中,该栈中只有一个元素.
    */
}
