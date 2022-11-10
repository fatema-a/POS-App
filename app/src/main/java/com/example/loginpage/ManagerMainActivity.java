package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerMainActivity extends AppCompatActivity {
    private Button LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // title
        getSupportActionBar().setTitle("Manager");

        LogOut = (Button)findViewById(R.id.btnLogOut4);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackMain();
            }
        });


    }

    public void goBackMain(){
        Intent intent = new Intent(ManagerMainActivity.this, MainPageActivity.class);
        startActivity(intent);
    }

}