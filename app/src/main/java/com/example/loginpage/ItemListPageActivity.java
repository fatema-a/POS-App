package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ItemListPageActivity extends AppCompatActivity {

    private EditText ActivityItemList;
    private ImageButton Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_page);

        ActivityItemList = (EditText)findViewById(R.id.etActivityItemList);
        Back = (ImageButton)findViewById(R.id.IbtnBack);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrevious();
            }
        });

    }

    public void openPrevious(){
        Intent intent = new Intent(ItemListPageActivity.this, EmployeeMainPageActivity.class);
        startActivity(intent);
    }
}
