package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class job extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        getSupportActionBar().setTitle("天天家政App - 雇主版");

        WebView webView = findViewById(R.id.webViewJobs);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://torontojiazheng.com/job_samples.php");
    }
}