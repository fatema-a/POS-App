package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApprovedPurchasesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_purchases);

        // title
        getSupportActionBar().setTitle("Purchased Orders");
        //back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }


}