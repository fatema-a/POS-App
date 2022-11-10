package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerMainActivity extends AppCompatActivity {
    Button LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);

        // title
        getSupportActionBar().setTitle("Manager");

        //logout
        LogOut=findViewById(R.id.BackManager);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerMainActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });

    }
}