package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ItemListPageActivity extends AppCompatActivity {

    private TextView ActivityItemList;
    private ImageButton Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_page);

        // title
        getSupportActionBar().setTitle("Item Purchase");

        ActivityItemList = findViewById(R.id.etActivityItemList);
        Back = (ImageButton)findViewById(R.id.IbtnBack);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrevious();
            }
        });

        DBHandler dbHandler = new DBHandler(this);
        TextView textView = findViewById(R.id.etActivityItemList);

        Cursor cursor = dbHandler.ViewData();

        StringBuilder stringBuilder = new StringBuilder();

        while(cursor.moveToNext()){
            stringBuilder.append("\nName : "+ cursor.getString(0)
                + "\nPrice : "+ cursor.getFloat(1));

        }
        ActivityItemList.setText(stringBuilder);

    }

    public void openPrevious(){
        Intent intent = new Intent(ItemListPageActivity.this, EmployeeMainPageActivity.class);
        startActivity(intent);
    }
}
