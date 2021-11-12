package com.example.defenceescortmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {

    TextView IndianArmy, IndianAF, IndianNavy, Paramilitary;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if(currentUser != null){
            getSupportActionBar().show();
        }else{
            getSupportActionBar().hide();
        }

        IndianArmy= findViewById(R.id.TVArmy);
        IndianAF= findViewById(R.id.TVAF);
        IndianNavy= findViewById(R.id.TVNavy);
        Paramilitary= findViewById(R.id.TVPara);

        IndianArmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this , EligibilityCriteria.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_page_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.eligibility:
                startActivity(new Intent(HomePage.this, EligibilityCriteria.class));
                break;

            case R.id.aboutus:
//                startActivity(new Intent(HomePage.this, SettingsActivity.class));
            break;

            case R.id.logout:
                signOut();

            break;

        }

        return true;
    }

    // sign out function
    public void signOut() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(HomePage.this);
        builder1.setMessage("Do you really want to sign out");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        firebaseAuth.signOut();
                        startActivity(new Intent(HomePage.this, LoginPage.class));
                        finish();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }



}