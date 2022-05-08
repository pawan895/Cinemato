package com.example.cinemato;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.*;

public class MainActivity extends AppCompatActivity {

    private Button signOut,pepsi,popcorn,faluda,pizza,checkOut,reset;
    public static int totalCost;
    public static boolean a,b,c,d;

    private TextView textViewToChange;
    FirebaseAuth mAuth;
    private String TotalCoststr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        setUpView();
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, Login.class));

            }
        });
        pepsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayPrice(1);

            }
        });
        popcorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayPrice(2);
            }
        });
        faluda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayPrice(3);
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayPrice(4);
            }
        });
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Payment.class));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayPrice(0);
            }
        });
//

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }
    private void setUpView(){
        signOut = (Button) findViewById(R.id.signOutBtn);
        pepsi = (Button) findViewById(R.id.pepsibtn);
        popcorn = (Button) findViewById(R.id.popcornbtn);
        faluda = (Button) findViewById(R.id.faludabtn);
        pizza = (Button) findViewById(R.id.pizzabtn);
        checkOut = (Button) findViewById(R.id.checkoutbtn);
        textViewToChange =  (TextView) findViewById(R.id.tvPrice);
        reset = (Button) findViewById(R.id.resetbtn);

    }


    private int displayPrice(int item){
        if (item == 1) {
            a = true;
            totalCost += 40;
            String msg = String.valueOf(totalCost);
            textViewToChange.setText(msg);
        }
        else if (item == 2){
            b = true;
            totalCost += 80;
            String msg = String.valueOf(totalCost);
            textViewToChange.setText(msg);
        }
        else if (item == 3){
            c = true;
            totalCost += 100;
            String msg = String.valueOf(totalCost);
            textViewToChange.setText(msg);
        }
        else if (item == 4){
            d = true;
            totalCost += 200;
            String msg = String.valueOf(totalCost);
            textViewToChange.setText(msg);
        }else if (item == 0){
            totalCost = 0;
            String msg = String.valueOf(totalCost);
            textViewToChange.setText(msg);
            a  =false;
            b =false;
            c = false;
            d = false;
        }
        return totalCost;

    }

}