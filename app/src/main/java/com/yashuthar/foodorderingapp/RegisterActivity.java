package com.yashuthar.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText regFullname;
    TextInputEditText regEmailId;
    TextInputEditText regMobileNo;
    TextInputEditText regAddress;
    TextInputEditText regPwd;
    Button signUp;
    Button haveAccount;
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regFullname = (TextInputEditText) findViewById(R.id.regFullname);
        regEmailId = (TextInputEditText) findViewById(R.id.regEmailId);
        regMobileNo = (TextInputEditText) findViewById(R.id.regMobileNo);
        regAddress = (TextInputEditText) findViewById(R.id.regAddress);
        regPwd = (TextInputEditText) findViewById(R.id.regPwd);
        signUp = (Button) findViewById(R.id.signUp);
        haveAccount = (Button) findViewById(R.id.haveAccount);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = regEmailId.getText().toString().trim();
                String pwd = regPwd.getText().toString().trim();
                String fullname = regFullname.getText().toString();
                String mobile = regMobileNo.getText().toString();
                String address = regAddress.getText().toString();

                if(TextUtils.isEmpty(emailId)){
                    regEmailId.setError("Enter Your Valid Email Id");
                }
                if(TextUtils.isEmpty(pwd)){
                    regPwd.setError("Enter Valid Password");
                }
                if(pwd.length() < 6){
                    regPwd.setError("Password must be greater than or equal to 6");
                }

                mAuth.createUserWithEmailAndPassword(emailId, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            userId = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fullname", fullname);
                            user.put("emailId", emailId);
                            user.put("mobile", mobile);
                            user.put("address", address);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("Success", "user profile is created for " + userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("Failure", "failed" + e.getMessage());
                                }
                            });
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Something Error Occured! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }
}