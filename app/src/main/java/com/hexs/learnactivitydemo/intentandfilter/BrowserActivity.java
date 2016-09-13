package com.hexs.learnactivitydemo.intentandfilter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.hexs.learnactivitydemo.R;

public class BrowserActivity extends AppCompatActivity {

    public static final String ACTION = "com.hexs.learnactivitydemo.intent.action.BrowserActivity";

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        wb = (WebView)findViewById(R.id.wb);
        wb.loadUrl("https://keroushe.github.io/");
    }
}
