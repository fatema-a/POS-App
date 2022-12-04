package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemListPageActivity extends AppCompatActivity {

    private TextView ActivityItemList;
    private ImageButton Back;

    DBHandler myDB;
    ArrayList<String> itemName, itemPrice;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_page);

        // title
        getSupportActionBar().setTitle("Item Purchase");

        //ActivityItemList = findViewById(R.id.etActivityItemList);
        Back = (ImageButton)findViewById(R.id.IbtnBack);

//        Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPrevious();
//            }
//        });

        myDB = new DBHandler(ItemListPageActivity.this);
        itemName = new ArrayList<>();
        itemPrice = new ArrayList<>();

        storeDataArray();
        customAdapter = new CustomAdapter(ItemListPageActivity.this, itemName, itemPrice);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ItemListPageActivity.this));
    }

    void storeDataArray(){
        Cursor cursor = myDB.realData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                itemName.add(cursor.getString(0));
                itemPrice.add(cursor.getString(1));
            }
        }
    }
}
