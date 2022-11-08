package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupplierMainPageActivity extends AppCompatActivity {

    private Button LogOut;
    private Button ProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_main_page);

        //Product history button



        //product list button

        ProductList = (Button) findViewById(R.id.btnProductList);
        ProductList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSupplierActivity();
            }
        });

        //logout button

        LogOut = (Button)findViewById(R.id.btnLogOut1);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackMain();
            }
        });
    }

    public void goBackMain(){
        Intent intent = new Intent(SupplierMainPageActivity.this, MainPageActivity.class);
        startActivity(intent);
    }
    // method to open supplier activity page
    public void openSupplierActivity() {
        Intent intent = new Intent(this, SupplierActivity.class);
        startActivity(intent);
    }
}