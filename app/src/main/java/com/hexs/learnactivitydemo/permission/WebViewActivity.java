package com.hexs.learnactivitydemo.permission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.hexs.learnactivitydemo.R;

public class WebViewActivity extends AppCompatActivity {

    private static final String TAG = "WebViewActivity";
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wv = (WebView)findViewById(R.id.webview);
        wv.loadUrl("https://keroushe.github.io");

        boolean isSuccessful = PermissionManger.checkpermission(this);
        Log.i(TAG, "----验证完成;isSuccessful = " + isSuccessful);

    }
}