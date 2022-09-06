package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void currentJobs(View view) {
        Intent intent = new Intent(getApplicationContext(),job.class);
        startActivity(intent);
    }



    public void userLogin2(View view) {
        Intent intent = new Intent(getApplicationContext(),UserLogin2.class);
        startActivity(intent);
    }

    public void showFriend(View view) {
        Intent intent = new Intent(getApplicationContext(),ShowFriend.class);
        startActivity(intent);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("天天家政App - 雇主版");

    }
}