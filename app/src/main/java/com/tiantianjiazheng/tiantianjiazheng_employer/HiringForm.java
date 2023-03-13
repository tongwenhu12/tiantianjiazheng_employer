package com.tiantianjiazheng.tiantianjiazheng_employer;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HiringForm extends AppCompatActivity {
//    private static final String TAG = "HiringForm";
//
//    private static final String KEY_TITLE = "name";
//    private static final String KEY_DESCRIPTION = "location";


    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    private EditText editTextName1;
    private EditText editTexttelephone1;
    private EditText editTextFamily;
    private EditText editTextHouse;
    private EditText editTextPet;


    private EditText editTextDays_week;
    private EditText editTextHow_long;
    private EditText editTextMain_task;
    private EditText editTextNanny_type;
    private EditText editTextRequirement;
    private EditText editTextSalary;
    private EditText editTextStart_date;
    private EditText editTextStart_end;


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("employers");
    private DocumentReference noteRef = db.document("employers/22082201");

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String userEmail = user.getEmail();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_form);

        editTextName1 = findViewById(R.id.name1);
        editTexttelephone1 = findViewById(R.id.telephone1);
        editTextFamily = findViewById(R.id.family);
        editTextHouse = findViewById(R.id.house);
        editTextPet = findViewById(R.id.pet);


        editTextDays_week = findViewById(R.id.days_week);
        editTextHow_long = findViewById(R.id.how_long);
        editTextMain_task = findViewById(R.id.main_task);
        editTextNanny_type = findViewById(R.id.nanny_type);
        editTextRequirement = findViewById(R.id.requirement);
        editTextSalary = findViewById(R.id.salary);
        editTextStart_date = findViewById(R.id.start_date);
        editTextStart_end = findViewById(R.id.start_end);

    }


    public void tt_submitJob(View v) {


        String name1 = editTextName1.getText().toString();
        String telephone1 = editTexttelephone1.getText().toString();
        String family = editTextFamily.getText().toString();
        String house = editTextHouse.getText().toString();
        String pet = editTextPet.getText().toString();

        String days_week = editTextDays_week.getText().toString();
        String how_long = editTextHow_long.getText().toString();
        String main_task = editTextMain_task.getText().toString();
        String nanny_type = editTextNanny_type.getText().toString();
        String requirement = editTextRequirement.getText().toString();
        String salary = editTextSalary.getText().toString();
        String start_date = editTextStart_date.getText().toString();
        String start_end =  editTextStart_end.getText().toString();


        Map<String, Object> jobs = new HashMap<>();




        jobs.put("name", name1);
        jobs.put("telephone", telephone1);
        jobs.put("family", family);
        jobs.put("house", house);
        jobs.put("pet", pet);

        jobs.put("days_week", days_week);
        jobs.put("how_long", how_long);
        jobs.put("main_task", main_task);
        jobs.put("nanny_type", nanny_type);
        jobs.put("requirement", requirement);
        jobs.put("salary", salary);
        jobs.put("start_date", start_date);
        jobs.put("start_end_time", start_end);
        jobs.put("employer's email", userEmail);

        db.collection("jobss").document(userEmail).update(jobs);


        Toast.makeText(getApplicationContext(), "工作信息 上传/修改 成功!",
                Toast.LENGTH_LONG).show();



    }

    public void tt_close(View v) {

        finish();

    }

    public void tt_logOut(View v) {

        mAuth.signOut();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();

        Toast.makeText(getApplicationContext(), "您已经成功退出登录。",
                Toast.LENGTH_LONG).show();

    }


}

