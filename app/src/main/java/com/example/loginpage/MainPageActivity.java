package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity {

    private Button Employee;
    private Button Manager;
    private Button Supplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // title
        getSupportActionBar().setTitle("User Login");

        Employee = (Button)findViewById(R.id.btnEmployee);
        Manager = (Button) findViewById(R.id.btnManager);
        Supplier = (Button)findViewById(R.id.btnSupplier);

        Employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        Manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openMainActivity();}
        });

        Supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

    public void openMainActivity(){
        Intent intent = new Intent(MainPageActivity.this, LoginPageActivity.class);
        startActivity(intent);
    }
}