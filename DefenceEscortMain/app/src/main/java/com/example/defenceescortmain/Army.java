package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Army extends AppCompatActivity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_army);

        myListView= findViewById(R.id.myListView);
        ArrayList<String> Examinations = new ArrayList<>();
        Examinations.add("National Defence Academy (NDA)");
        Examinations.add("UPSC Combined Defence Services Examination (CDS)");
        Examinations.add("SSC TECH (Short Service Commission Technical Entry)");
        Examinations.add("10+2 Technical Entry Scheme (TES)");
        Examinations.add("NCC SPECIAL ENTRY");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Examinations);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item in a Toast
                // Toast.makeText(view.getContext(), selectedItem, Toast.LENGTH_LONG).show();
                if (selectedItem.equals("National Defence Academy (NDA)")){
                    Intent intent = new Intent(Army.this , ArmyNDA.class);
                    startActivity(intent);
                }else if (selectedItem.equals("UPSC Combined Defence Services Examination (CDS)")){
                    Intent intent = new Intent(Army.this , ArmyCDS.class);
                    startActivity(intent);
                }else if (selectedItem.equals("SSC TECH (Short Service Commission Technical Entry)")){
                    Intent intent = new Intent(Army.this , ArmySSC.class);
                    startActivity(intent);
                }else if (selectedItem.equals("10+2 Technical Entry Scheme (TES)")){
                    Intent intent = new Intent(Army.this , ArmyTES.class);
                    startActivity(intent);
                }else if (selectedItem.equals("NCC SPECIAL ENTRY")){
                    Intent intent = new Intent(Army.this , ArmyNCC.class);
                    startActivity(intent);
                }

            }

        });
    }
}