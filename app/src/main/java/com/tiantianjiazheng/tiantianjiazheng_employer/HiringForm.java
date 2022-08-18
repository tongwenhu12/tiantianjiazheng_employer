package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;



public class HiringForm extends AppCompatActivity {

    EditText workLocation,pet,houseSize,comeFrom,startDate,hireLength;
    Button submitJob;
    FirebaseFirestore db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_form);

        db = FirebaseFirestore.getInstance();

        workLocation = findViewById(R.id.tt_workLocation);
        pet = findViewById(R.id.tt_pet);
        houseSize = findViewById(R.id.tt_houseSize);
        comeFrom = findViewById(R.id.tt_comeFrom);
        startDate = findViewById(R.id.tt_startDate);
        hireLength = findViewById(R.id.tt_hireLength);

        submitJob = findViewById(R.id.tt_submitJob);


        submitJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String WorkLocation = workLocation.getText().toString();
                String Pet = pet.getText().toString();
                String HouseSize = houseSize.getText().toString();
                String ComeFrom = comeFrom.getText().toString();
                String StartDate = startDate.getText().toString();
                String HireLength = hireLength.getText().toString();




                Map<String,Object> user = new HashMap<>();

                user.put("WorkLocation",WorkLocation);
                user.put("Pet",Pet);
                user.put("HouseSize",HouseSize);
                user.put("ComeFrom",ComeFrom);
                user.put("StartDate",StartDate);
                user.put("HireLength",HireLength);






                db.collection("user")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(HiringForm.this,"Successful",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {

                                Toast.makeText(HiringForm.this,"Failed",Toast.LENGTH_SHORT).show();


                            }
                        });

            }
        });









    }
}