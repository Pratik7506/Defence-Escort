package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread loadscreen=new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    super.run();
                    sleep(1000);  //Delay of 1 seconds
                } catch (Exception e) {
                    Log.d("error", e.getMessage());
                } finally {
                    startActivity(new Intent(MainActivity.this, LoginPage.class));
                    finish();
                }
            }
        };
        loadscreen.start();
    }
}