package com.hexs.learnactivitydemo.basicstudy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hexs.learnactivitydemo.DemoApplication;
import com.hexs.learnactivitydemo.R;
import com.hexs.learnactivitydemo.intentandfilter.BrowserActivity;

public class MainActivity extends Activity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnstartActivity).setOnClickListener(listener);
        findViewById(R.id.btnstartActivityForResult).setOnClickListener(listener);
        findViewById(R.id.btnstartActionUriActivity).setOnClickListener(listener);

        showApplicationInfo();
        saveApplicationInfo();
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnstartActivity: {
                    Intent intent = new Intent(MainActivity.this, BActivity.class);
                    intent.putExtra("data", "this is MainActivity");

                    Bundle bundle = new Bundle();
                    User user = new User("hexs", "123456");
                    bundle.putSerializable("user", user);
                    Student student = new Student("xiaoming", "12345", 1355);
                    bundle.putParcelable("student", student);

                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                }
                case R.id.btnstartActivityForResult: {
                    Intent intent = new Intent(CActivity.ACTION);
                    startActivityForResult(intent, 1);
                    break;
                }
                case R.id.btnstartActionUriActivity: {
                    Intent intent = new Intent(BrowserActivity.ACTION, Uri.parse("app://browseractivity"));
                    startActivity(intent);
                    break;
                }
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String resultText = data.getStringExtra("data");
        Log.i(TAG, "返回的数据为: requestCode = " + requestCode + ",resultCode = " + resultCode + ",resultText = " + resultText);
    }

    private void saveApplicationInfo() {
        ((DemoApplication) getApplication()).setUsername("hexs");
        ((DemoApplication) getApplication()).setPassword("123456");
    }

    private void showApplicationInfo() {
        String username = ((DemoApplication) getApplication()).getUsername();
        String password = ((DemoApplication) getApplication()).getPassword();
        Log.e(TAG, "username = " + username + ",password = " + password);
    }


}
