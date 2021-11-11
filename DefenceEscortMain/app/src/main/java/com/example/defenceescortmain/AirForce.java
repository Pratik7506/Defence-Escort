package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AirForce extends AppCompatActivity {

    ListView myLVaf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_force);

        myLVaf= findViewById(R.id.myLV);
        ArrayList<String> Examinations = new ArrayList<>();
        Examinations.add("AFCAT (Air Force Common Admission Test)");
        Examinations.add("National Defence Academy (NDA)");
        Examinations.add("NCC Special Entry");
        Examinations.add("UPSC Combined Defence Services Examination (CDS)");
        Examinations.add("XY Group");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Examinations);
        myLVaf.setAdapter(arrayAdapter);

        myLVaf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item in a Toast
                // Toast.makeText(view.getContext(), selectedItem, Toast.LENGTH_LONG).show();
                if (selectedItem.equals("AFCAT (Air Force Common Admission Test)")){
                    Intent intent = new Intent(AirForce.this , AfAFCAT.class);
                    startActivity(intent);
                }else if (selectedItem.equals("National Defence Academy (NDA)")){
                    Intent intent = new Intent(AirForce.this , AfNDA.class);
                    startActivity(intent);
                }else if (selectedItem.equals("NCC Special Entry")){
                    Intent intent = new Intent(AirForce.this , AfNCC.class);
                    startActivity(intent);
                } else if (selectedItem.equals("UPSC Combined Defence Services Examination (CDS)")){
                    Intent intent = new Intent(AirForce.this , AfCDS.class);
                    startActivity(intent);
                }else if (selectedItem.equals("XY Group")){
                    Intent intent = new Intent(AirForce.this , AfXY.class);
                    startActivity(intent);
                }
            }
        });
    }
}