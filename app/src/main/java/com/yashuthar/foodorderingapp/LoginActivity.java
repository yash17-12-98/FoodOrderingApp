package com.yashuthar.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText loginEmailId;
    TextInputEditText loginPwd;
    Button signIn;
    Button newUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText loginEmailId = (TextInputEditText) findViewById(R.id.loginEmailId);
        TextInputEditText loginPwd = (TextInputEditText) findViewById(R.id.loginPwd);
        Button signIn = (Button) findViewById(R.id.signIn);
        Button newUser = (Button) findViewById(R.id.newUser);
        mAuth = FirebaseAuth.getInstance();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = loginEmailId.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                if(TextUtils.isEmpty(emailId)){
                    loginEmailId.setError("Enter Your Valid Email Id");
                }
                if(TextUtils.isEmpty(pwd)){
                    loginPwd.setError("Enter Valid Password");
                }
                if(pwd.length() < 6){
                    loginPwd.setError("Password must be greater than or equal to 6");
                }

                mAuth.signInWithEmailAndPassword(emailId, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Error Occured! " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }

        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
            }
        });



    }


}