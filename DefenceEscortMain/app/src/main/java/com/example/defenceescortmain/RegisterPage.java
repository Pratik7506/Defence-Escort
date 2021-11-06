package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    EditText Name;
    EditText Email;
    EditText Phone;
    EditText Password;
    Button Register;
    TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        Name = findViewById(R.id.ETName);
        Email = findViewById(R.id.EtEmailid);
        Password = findViewById(R.id.EtPass);
        Phone= findViewById(R.id.EtPass);
        Register = (Button) findViewById(R.id.BtReg);
        Login = findViewById(R.id.TvLog);

        Toast.makeText(RegisterPage.this, Register.getText(), Toast.LENGTH_LONG).show();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkDataEntered()){
                    Intent intent = new Intent(RegisterPage.this , LoginPage.class);
                    startActivity(intent);
                }

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterPage.this , LoginPage.class);
                startActivity(intent);
            }
        });

    }



    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean checkDataEntered() {
        if (isEmpty(Name)) {
            Toast t = Toast.makeText(this, "You must enter name to register!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(Email)) {
            Email.setError("Email is required!");
            return false;
        }

        if (isEmpty(Password) ) {
            Password.setError("Enter valid Password!");
            return false;
        }

        if (isEmpty(Phone)) {
            Phone.setError("Phone no. is required");
            return false;
        }
        return true;
    }
}