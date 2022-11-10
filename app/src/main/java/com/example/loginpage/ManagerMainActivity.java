package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManagerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);

        // title
        getSupportActionBar().setTitle("Manager");

        //logout


    }
}