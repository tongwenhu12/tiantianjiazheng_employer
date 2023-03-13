package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.content.Intent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class userLogin3 extends AppCompatActivity {


    // initiate SharedPreferences
//    SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

    private FirebaseAuth mAuth;

    private EditText ss_username ;
    private EditText ss_password ;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("employers");
    private DocumentReference noteRef = db.document("employers/22082201");

//    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//    String userEmail = user.getEmail();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login3);

        mAuth = FirebaseAuth.getInstance();


        ss_username = findViewById(R.id.ss_username);
        ss_password = findViewById(R.id.ss_password);

        if (mAuth.getCurrentUser() != null) {
            logIn();
        }


    }


    public void ss_login(View View) {

        String email2,password2;

        email2 = String.valueOf(ss_username.getText());
        password2 = String.valueOf(ss_password.getText());

        mAuth.signInWithEmailAndPassword(email2, password2)
   //     mAuth.signInWithEmailAndPassword(ss_username.toString(), ss_password.toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            logIn();
                            Toast.makeText(getApplicationContext(), "Sign in succeed!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Sign in failed!",
                                    Toast.LENGTH_LONG).show();


                        }
                    }
                });


    }


    public void ss_register(View View){

        String email2,password2;

        email2 = String.valueOf(ss_username.getText());
        password2 = String.valueOf(ss_password.getText());

        mAuth.createUserWithEmailAndPassword(email2, password2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            logIn();
                            Toast.makeText(getApplicationContext(), " Registration is successful!",
                                    Toast.LENGTH_LONG).show();

                            String email3 = String.valueOf(ss_username.getText());

                            String[] applicants = {};
                            String[] applicants_v2 = {};

                            Map<String, Object> jobs = new HashMap<>();

                            jobs.put("level", 0);
                            jobs.put("applicants", Arrays.asList(applicants));
                            jobs.put("applicants_v2", Arrays.asList(applicants_v2));
                            jobs.put("employer's email", email3);

                            db.collection("jobss").document(email3).set(jobs);



                            SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

  // to save to SharedPreferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("userEmail", email2);
                            editor.putString("name", "");
                            editor.putString("telephone", "");
                            editor.putString("house", "");
                            editor.putString("location", "");
                            editor.putString("family", "");
                            editor.putString("pet", "");

                            editor.apply();


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Registration failed!",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                });



    }





        // Move to next Activity
        public void logIn() {

        Intent intent = new Intent(getApplicationContext(),DidLogin.class);
        startActivity(intent);


    }




}