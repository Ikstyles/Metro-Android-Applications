package com.example.signuploginrealtime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPassword, signupUsername;
    private Button signupButton;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupUsername = findViewById(R.id.signup_username); // Add this line
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signupEmail.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();
                String username = signupUsername.getText().toString().trim(); // Get username

                if (email.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                    return;
                }
                if (password.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                    return;
                }
                if (username.isEmpty()){ // Check if username is empty
                    signupUsername.setError("Username cannot be empty");
                    return;
                }

                // Sign up the user with email and password
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Set display name
                                    FirebaseUser user = auth.getCurrentUser();
                                    if (user != null) {
                                        user.updateProfile(new UserProfileChangeRequest.Builder()
                                                        .setDisplayName(username)
                                                        .build())
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(SignupActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                                                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                                        } else {
                                                            Toast.makeText(SignupActivity.this, "Failed to set display name", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }
                                } else {
                                    Toast.makeText(SignupActivity.this, "Sign up failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

    }
}
