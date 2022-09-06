package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DidLogin extends AppCompatActivity {

    public void employerNotice2(View view) {
        Intent intent = new Intent(getApplicationContext(),notice.class);
        startActivity(intent);
    }

    public void hiringForm2(View view) {
        Intent intent = new Intent(getApplicationContext(),HiringForm.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_login);
    }
}