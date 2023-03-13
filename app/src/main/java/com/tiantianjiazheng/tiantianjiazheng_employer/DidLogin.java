package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class DidLogin extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();









    private EditText name6;
    private EditText telephone6;
    private EditText house6;
    private EditText family6;
    private EditText pet6;
    private EditText location6;





    public void employerNotice2(View view) {
        Intent intent = new Intent(getApplicationContext(),notice.class);
        startActivity(intent);
    }

    public void uploadModify(View view) {

        String name66 = name6.getText().toString();
        String telephone66 = telephone6.getText().toString();
        String house66 = house6.getText().toString();
        String location66 = location6.getText().toString();
        String family66 = family6.getText().toString();
        String pet66 = pet6.getText().toString();




//  to retrieve from SharedPreferences





        if ( name66.equals("") || telephone66.equals("") || name66.equals("") || house66.equals("") || location66.equals("") || family66.equals("") || pet66.equals("") ){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("请检查");
            builder.setMessage("所有项目必须填。");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do something when the OK button is clicked
                }
            });

            builder.show();


        } else {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

            // to save to SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
//          editor.putString("userEmail", email2);
            editor.putString("name", name66);
            editor.putString("telephone", telephone66);
            editor.putString("house", house66);
            editor.putString("location", location66);
            editor.putString("family", family66);
            editor.putString("pet", pet66);

            editor.apply();




            Intent intent = new Intent(getApplicationContext(),HiringForm.class);
            startActivity(intent);

        }

    }

    public void close(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);


        finish();
    }

    public void logOut(View view) {
        mAuth.signOut();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();

        Toast.makeText(getApplicationContext(), "您已经成功退出登录。",
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_login);

        name6 = findViewById(R.id.name6);
        telephone6 = findViewById(R.id.telephone6);
        house6 = findViewById(R.id.house6);
        family6 = findViewById(R.id.family6);
        pet6 = findViewById(R.id.pet6);
        location6 = findViewById(R.id.location6);


        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        //  to retrieve from SharedPreferences
        String myValue1 = sharedPreferences.getString("userEmail", "");
        String myValue2 = sharedPreferences.getString("name", "");
        String myValue3 = sharedPreferences.getString("telephone", "");
        String myValue4 = sharedPreferences.getString("house", "");
        String myValue5 = sharedPreferences.getString("location", "");
        String myValue6 = sharedPreferences.getString("pet", "");
        String myValue7 = sharedPreferences.getString("family", "");

        name6.setText(myValue2);
        telephone6.setText(myValue3);
        house6.setText(myValue4);
        family6.setText(myValue7);
        pet6.setText(myValue6);
        location6.setText(myValue5);

    }
}