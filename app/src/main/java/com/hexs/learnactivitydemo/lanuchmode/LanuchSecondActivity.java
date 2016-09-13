package com.hexs.learnactivitydemo.lanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hexs.learnactivitydemo.R;

public class LanuchSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuch_second);

        findViewById(R.id.btnJump1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchSecondActivity.this, LanuchFirstActivity.class));
            }
        });

        findViewById(R.id.btnJump2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchSecondActivity.this, LanuchSecondActivity.class));
            }
        });
    }
}
