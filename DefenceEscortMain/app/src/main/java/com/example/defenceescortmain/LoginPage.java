package com.example.defenceescortmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    EditText Email, Password;
    Button Login;
    TextView Register, Skip;
    boolean isEmailValid, isPasswordValid;

    private FirebaseAuth firebaseAuth;
    private String TAG = "LoginPage.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btLogin);
        Register = (TextView) findViewById(R.id.tvRegister);
        Skip = (TextView) findViewById(R.id.tvSkip);


        firebaseAuth = FirebaseAuth.getInstance();


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                loginUser(Email.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);
            }
        });

        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid email address.
        if (Email.getText().toString().isEmpty()) {
            Email.setError("Email cannot be empty");
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
            Email.setError("Enter Valid Email");
            isEmailValid = false;
        } else  {
            isEmailValid = true;
            Email.setError(null);
        }

        // Check for a valid password.
        if (Password.getText().toString().isEmpty()) {
            Password.setError("Password cannot be empty");
            isPasswordValid = false;
        } else if (Password.getText().length() < 6) {
            Password.setError("Enter Valid Password");
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
            Password.setError(null);
        }

        if (isEmailValid && isPasswordValid) {
            //Toast.makeText(LoginPage.this, "Successfully", Toast.LENGTH_SHORT).show();

        }

    }

    private void loginUser(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(LoginPage.this, "Authentication success",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginPage.this, HomePage.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }
}