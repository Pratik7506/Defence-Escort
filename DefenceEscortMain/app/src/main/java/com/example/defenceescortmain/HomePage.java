package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView IndianArmy, IndianAF, IndianNavy, Paramilitary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        IndianArmy= findViewById(R.id.TVArmy);
        IndianAF= findViewById(R.id.TVAF);
        IndianNavy= findViewById(R.id.TVNavy);
        Paramilitary= findViewById(R.id.TVPara);

        IndianArmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this , Army.class);
                startActivity(intent);
            }
        });

        IndianAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this , AirForce.class);
                startActivity(intent);
            }
        });

        IndianNavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this , Navy.class);
                startActivity(intent);
            }
        });

        Paramilitary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this , Paramilitary.class);
                startActivity(intent);
            }
        });
    }
}