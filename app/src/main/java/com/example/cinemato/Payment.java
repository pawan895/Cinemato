package com.example.cinemato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment extends AppCompatActivity {
    private TextView orderPrice,orderlist;
    private Button paymentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setUpView();
        String OrderMsg = String.valueOf(MainActivity.totalCost);
        orderPrice.setText(OrderMsg);

        paymentPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Payment.this, OrderReview.class));
            }
        });

        if (MainActivity.a && MainActivity.b && MainActivity.c && MainActivity.d) {
            orderlist.setText("Pepsi,\nPopcorn medium,\nRoyal faluda,\nPizza Large");
        }else if (MainActivity.a && MainActivity.b && MainActivity.c) {
            orderlist.setText("Pepsi,\nPopcorn Medium,\nRoyal faluda.");
        }else if (MainActivity.a && MainActivity.b && MainActivity.d) {
            orderlist.setText("Pepsi,\nPopcorn Medium,\nPizza Large.");
        }else if (MainActivity.a && MainActivity.d && MainActivity.c) {
            orderlist.setText("Pepsi,\nPizza Large,\nRoyal faluda.");
        }else if (MainActivity.d && MainActivity.b && MainActivity.c) {
            orderlist.setText("Pizza Large,\nPopcorn Medium,\nRoyal faluda.");
        }else if (MainActivity.a && MainActivity.b) {
            orderlist.setText("Pepsi,\nPopcorn Medium.\n");
        }else if (MainActivity.a && MainActivity.c) {
            orderlist.setText("Pepsi,\nRoyal faluda.\n");}
        else if (MainActivity.a && MainActivity.d) {
            orderlist.setText("Pepsi,\nPizza Large.\n");}
        else if (MainActivity.b && MainActivity.c) {
            orderlist.setText("Popcorn Medium,\nRoyal faluda.\n");}
        else if (MainActivity.b && MainActivity.d) {
            orderlist.setText("Popcorn Medium,\nPizza Large\n");}
        else if (MainActivity.c && MainActivity.d) {
            orderlist.setText("Royal faluda,\nPiza Large");}
        else if (MainActivity.a) {
            orderlist.setText("Pepsi.");
        }
        else if (MainActivity.b) {
            orderlist.setText("Popcorn.");
        }
        else if (MainActivity.c) {
            orderlist.setText("Royal faluda.");
        }
        else if (MainActivity.d) {
            orderlist.setText("Pizza Large.");
        }



    }
    private void setUpView(){
        orderPrice =  (TextView) findViewById(R.id.tvTotatprice);
        orderlist =  (TextView) findViewById(R.id.tvOrderitem);
        paymentPage = (Button) findViewById(R.id.PayNowBtn);

    }
}