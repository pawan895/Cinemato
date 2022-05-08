package com.example.cinemato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderReview extends AppCompatActivity {
    private TextView orderItem;
    private Button about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);
        setUpView();
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderReview.this,Info.class));
            }
        });
        if (MainActivity.a && MainActivity.b && MainActivity.c && MainActivity.d) {
            orderItem.setText("Pepsi,\nPopcorn medium,\nRoyal faluda,\nPizza Large");
        }else if (MainActivity.a && MainActivity.b && MainActivity.c) {
            orderItem.setText("Pepsi,\nPopcorn Medium,\nRoyal faluda.");
        }else if (MainActivity.a && MainActivity.b && MainActivity.d) {
            orderItem.setText("Pepsi,\nPopcorn Medium,\nPizza Large.");
        }else if (MainActivity.a && MainActivity.d && MainActivity.c) {
            orderItem.setText("Pepsi,\nPizza Large,\nRoyal faluda.");
        }else if (MainActivity.d && MainActivity.b && MainActivity.c) {
            orderItem.setText("Pizza Large,\nPopcorn Medium,\nRoyal faluda.");
        }else if (MainActivity.a && MainActivity.b) {
            orderItem.setText("Pepsi,\nPopcorn Medium.\n");
        }else if (MainActivity.a && MainActivity.c) {
            orderItem.setText("Pepsi,\nRoyal faluda.\n");}
        else if (MainActivity.a && MainActivity.d) {
            orderItem.setText("Pepsi,\nPizza Large.\n");}
        else if (MainActivity.b && MainActivity.c) {
            orderItem.setText("Popcorn Medium,\nRoyal faluda.\n");}
        else if (MainActivity.b && MainActivity.d) {
            orderItem.setText("Popcorn Medium,\nPizza Large\n");}
        else if (MainActivity.c && MainActivity.d) {
            orderItem.setText("Royal faluda,\nPiza Large");}
        else if (MainActivity.a) {
            orderItem.setText("Pepsi.");
        }
        else if (MainActivity.b) {
            orderItem.setText("Popcorn.");
        }
        else if (MainActivity.c) {
            orderItem.setText("Royal faluda.");
        }
        else if (MainActivity.d) {
            orderItem.setText("Pizza Large.");
        }
        }


    private void setUpView(){
        orderItem =  (TextView) findViewById(R.id.tvOrderinfo);
        about =  (Button) findViewById(R.id.aboutBtn);

    }

}