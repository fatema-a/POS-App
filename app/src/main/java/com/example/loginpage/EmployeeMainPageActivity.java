package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmployeeMainPageActivity extends AppCompatActivity {

    private Button History;
    private Button ItemList;
    private Button LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_main_page);

        History = (Button)findViewById(R.id.btnHistory);
        ItemList = (Button)findViewById(R.id.btnItemList);
        LogOut = (Button)findViewById(R.id.btnBack2);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackMain();
            }
        });

        ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });

        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });

    }

    public void goBackMain(){
        Intent intent = new Intent(EmployeeMainPageActivity.this, MainPageActivity.class);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent = new Intent(this, HistoryPageActivity.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this, ItemListPageActivity.class);
        startActivity(intent);
    }
}
