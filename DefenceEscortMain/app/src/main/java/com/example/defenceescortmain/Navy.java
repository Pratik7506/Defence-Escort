package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Navy extends AppCompatActivity {

    ListView myLVNavy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navy);

        myLVNavy= findViewById(R.id.mynavy);

        ArrayList<String> Examinations = new ArrayList<>();
        Examinations.add("Indian Navy Entrance Test (INET)");
        Examinations.add("UPSC Combined Defence Services Examination (CDS)");
        Examinations.add("National Defence Academy (NDA)");
        Examinations.add("NCC Special Entry");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Examinations);
        myLVNavy.setAdapter(arrayAdapter);

        myLVNavy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item in a Toast
                //   Toast.makeText(view.getContext(), selectedItem, Toast.LENGTH_LONG).show();
                if (selectedItem.equals("Indian Navy Entrance Test (INET)")){
                    Intent intent = new Intent(Navy.this , NavyINET.class);
                    startActivity(intent);
                }else if (selectedItem.equals("UPSC Combined Defence Services Examination (CDS)")){
                    Intent intent = new Intent(Navy.this , NavyCDS.class);
                    startActivity(intent);
                }else if (selectedItem.equals("National Defence Academy (NDA)")){
                    Intent intent = new Intent(Navy.this , NavyNDA.class);
                    startActivity(intent);
                }else if (selectedItem.equals("NCC Special Entry")){
                    Intent intent = new Intent(Navy.this , NavyNCC.class);
                    startActivity(intent);
                }
            }
        });
    }
}