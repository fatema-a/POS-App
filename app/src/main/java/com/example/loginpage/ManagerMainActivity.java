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
        setContentView(R.layout.activity_manager_main);

        //LogOut = (Button)findViewById(R.id.btnLogOut);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMainPage();
            }
        });

    }

    public void goMainPage(){
        Intent intent = new Intent(ManagerMainActivity.this, MainPageActivity.class);
        startActivity(intent);
    }
}