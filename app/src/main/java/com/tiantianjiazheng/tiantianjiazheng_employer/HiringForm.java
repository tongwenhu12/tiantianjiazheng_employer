package com.tiantianjiazheng.tiantianjiazheng_employer;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class HiringForm extends AppCompatActivity {
    private static final String TAG = "HiringForm";

    private static final String KEY_TITLE = "name";
    private static final String KEY_DESCRIPTION = "location";

    private EditText editTextName;
    private EditText editTextLocation;
    private TextView textViewData;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("employers");
    private DocumentReference noteRef = db.document("employers/22082201");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_form);

        editTextName = findViewById(R.id.edit_text_name2);
        editTextLocation = findViewById(R.id.edit_text_location2);
        textViewData = findViewById(R.id.text_view_data2);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
//                if (e != null) {
//                    return;
//                }
//
//                String data = "";
//
//                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                    Note note = documentSnapshot.toObject(Note.class);
//                    note.setDocumentId(documentSnapshot.getId());
//
//                    String documentId = note.getDocumentId();
//                    String title = note.getName();
//                    String description = note.getLocation();
//
//                    data += "ID: " + documentId
//                            + "\nTitle: " + title + "\nDescription: " + description + "\n\n";
//                }
//
//                textViewData.setText(data);
//            }
//        });
//    }

    public void tt_submitJob(View v) {

        String name = editTextName.getText().toString();
        String location = editTextLocation.getText().toString();

        Map<String, Object> jobs = new HashMap<>();
        jobs.put("first", name);
        jobs.put("last", location);
        jobs.put("born", 96969);

        db.collection("jobs").document("2300000").set(jobs);


    }

//    public void loadEmployers2(View v) {
//        notebookRef.get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        String data = "";
//
//                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                            Note note = documentSnapshot.toObject(Note.class);
//                            note.setDocumentId(documentSnapshot.getId());
//
//                            String documentId = note.getDocumentId();
//                            String name = note.getName();
//                            String location = note.getLocation();
//
//                            data += "ID: " + documentId
//                                    + "\nName: " + name + "\nLocation: " + location + "\n\n";
//                        }
//
//                        textViewData.setText(data);
//                    }
//                });
//    }
}




//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//import org.jetbrains.annotations.NotNull;
//import java.util.HashMap;
//import java.util.Map;
//
//
//
//public class HiringForm extends AppCompatActivity {
//
//    EditText workLocation,pet,houseSize,comeFrom,startDate,hireLength;
//    Button submitJob;
//    FirebaseFirestore db;
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hiring_form);
//
//        db = FirebaseFirestore.getInstance();
//
//        workLocation = findViewById(R.id.tt_workLocation);
//        pet = findViewById(R.id.tt_pet);
//        houseSize = findViewById(R.id.tt_houseSize);
//        comeFrom = findViewById(R.id.tt_comeFrom);
//        startDate = findViewById(R.id.tt_startDate);
//        hireLength = findViewById(R.id.tt_hireLength);
//
//        submitJob = findViewById(R.id.tt_submitJob);
//
//
//        submitJob.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String WorkLocation = workLocation.getText().toString();
//                String Pet = pet.getText().toString();
//                String HouseSize = houseSize.getText().toString();
//                String ComeFrom = comeFrom.getText().toString();
//                String StartDate = startDate.getText().toString();
//                String HireLength = hireLength.getText().toString();
//
//
//
//
//                Map<String,Object> user = new HashMap<>();
//
//                user.put("WorkLocation",WorkLocation);
//                user.put("Pet",Pet);
//                user.put("HouseSize",HouseSize);
//                user.put("ComeFrom",ComeFrom);
//                user.put("StartDate",StartDate);
//                user.put("HireLength",HireLength);
//
//
//
//
//
//
//                db.collection("user")
//                        .add(user)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                Toast.makeText(HiringForm.this,"Successful",Toast.LENGTH_SHORT).show();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull @NotNull Exception e) {
//
//                                Toast.makeText(HiringForm.this,"Failed",Toast.LENGTH_SHORT).show();
//
//
//                            }
//                        });
//
//            }
//        });
//
//
//
//
//
//
//
//
//
//    }
//}