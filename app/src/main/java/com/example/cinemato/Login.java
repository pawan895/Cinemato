package com.example.cinemato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.*;

public class Login extends AppCompatActivity {

    private EditText MobileNumber,TicketId;
    private Button loginButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpUIviews();
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUserDetails()){
                    //database connection
                    String user_number = MobileNumber.getText().toString().trim();
                    String user_id = TicketId.getText().toString().trim();

                    mAuth.signInWithEmailAndPassword(user_number,user_id).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(Login.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }

            }
        });

    }
    private void setUpUIviews(){
        mAuth = FirebaseAuth.getInstance();
        MobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        TicketId = (EditText) findViewById(R.id.etTicketId);
        loginButton = (Button) findViewById(R.id.loginbtn);
    }
    private boolean validateUserDetails(){
        Boolean result = false;
        String number = MobileNumber.getText().toString();
        String Id = TicketId.getText().toString();

        if (number.isEmpty()||Id.isEmpty()) {
            Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
            result = false;
        }
        else result = true;
        return result;
    }


}