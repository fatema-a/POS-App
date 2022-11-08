package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApprovedPurchasesActivity extends AppCompatActivity {
    private Button LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_purchases);

        //logout from approval page
        LogOut = (Button)findViewById(R.id.btnLogOut2);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackMain2();
            }
        });

    }
    public void goBackMain2(){
        Intent intent = new Intent(ApprovedPurchasesActivity.this, MainPageActivity.class);
        startActivity(intent);
    }

}