package com.hexs.learnactivitydemo.basicstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hexs.learnactivitydemo.R;

/**
 * Created by hexs on 16/9/13.
 */
public class BActivity extends Activity {

    private static String TAG = "BActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_layout);

        Intent intent = getIntent();
        Log.i(TAG, "data = " + intent.getStringExtra("data"));
        Bundle bundle = intent.getExtras();
        User user = (User) bundle.getSerializable("user");
        Log.i(TAG, "user = " + user);
        Student student = bundle.getParcelable("student");
        Log.i(TAG, "student = " + student);
    }
}
