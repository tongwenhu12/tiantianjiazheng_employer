package com.tiantianjiazheng.tiantianjiazheng_employer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class testActivity extends AppCompatActivity {

    String items [] = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 2", "Item 3", "Item 4", "Item 5", "Item 2", "Item 3", "Item 4", "Item 5", "Item 2", "Item 3", "Item 4", "Item 5", "Item 2", "Item 3", "Item 4", "Item 5"};
    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listView =  findViewById(R.id.tongListView);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view2,R.id.textView,items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the click event here

                Toast.makeText(getApplicationContext(), "clicked" + position,
                        Toast.LENGTH_SHORT).show();


            }
        });

    }
}