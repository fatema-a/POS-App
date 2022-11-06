package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class SupplierActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText nameEdt, priceEdt, findNameEdt, changePriceEdt;
    private Button addItemBtn, editItemBtn, readInventoryBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        //  variable initialization
        nameEdt = findViewById(R.id.idEdtName);
        priceEdt = findViewById(R.id.idEdtPrice);
        addItemBtn = findViewById(R.id.idBtnAddItem);

        findNameEdt = findViewById(R.id.idEdtFindName);
        changePriceEdt = findViewById(R.id.idEdtChangePrice);
        editItemBtn = findViewById(R.id.idBtnEditItem);


        // creating a new dbhandler class
        dbHandler = new DBHandler(SupplierActivity.this);

        // on click listener for our addItem method from DB.
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String itemName = nameEdt.getText().toString();
                String itemPrice = priceEdt.getText().toString();


                // validating if the text fields are empty or not.
                if (itemName.isEmpty() && itemPrice.isEmpty()) {
                    Toast.makeText(SupplierActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // method to add item and price to DB
                dbHandler.addItem(itemName, itemPrice);

                // after adding the data we are displaying a toast message.
                Toast.makeText(SupplierActivity.this, "Item has been added to inventory.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                priceEdt.setText("");
            }
        });

        editItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String itemName =  findNameEdt.getText().toString();
                String itemPrice = changePriceEdt.getText().toString();


                // validating if the text fields are empty or not.
                if (itemName.isEmpty() && itemPrice.isEmpty()) {
                    Toast.makeText(SupplierActivity.this, "cookies", Toast.LENGTH_SHORT).show();
                    return;
                }

                // method to add item and price to DB
                dbHandler.editItem(itemName, itemPrice);

                // after adding the data we are displaying a toast message.
                Toast.makeText(SupplierActivity.this, "Item price has been updated in the inventory.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                priceEdt.setText("");
            }
        });



    }


}