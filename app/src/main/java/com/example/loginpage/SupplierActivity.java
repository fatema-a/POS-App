package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class SupplierActivity extends AppCompatActivity {

    // creates variables for  editText button and dbhandler
    private EditText nameEdt, priceEdt, findNameEdt, changePriceEdt, deleteItemEdt;
    private Button addItemBtn, editItemBtn, deleteItemBtn, readInventoryBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        // initializes editText and button for adding item and prices to inventory
        nameEdt = findViewById(R.id.idEdtName);
        priceEdt = findViewById(R.id.idEdtPrice);
        addItemBtn = findViewById(R.id.idBtnAddItem);

        // initializes editText and button for editing items in inventory
        findNameEdt = findViewById(R.id.idEdtFindName);
        changePriceEdt = findViewById(R.id.idEdtChangePrice);
        editItemBtn = findViewById(R.id.idBtnEditItem);

        // initializes EditText and button for deleting item from inventory
        deleteItemEdt = findViewById(R.id.idEdtDeleteItem);
        deleteItemBtn = findViewById(R.id.idBtnDeleteItem);

        // creates a new dbhandler class
        dbHandler = new DBHandler(SupplierActivity.this);

        // on click listener for our addItem method from DBHandler
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // gets data from all editText fields
                String itemName = nameEdt.getText().toString();
                String itemPrice = priceEdt.getText().toString();


                // checks to see if editText is empty
                if (itemName.isEmpty() && itemPrice.isEmpty()) {
                    Toast.makeText(SupplierActivity.this, "Please fill in all the forms", Toast.LENGTH_SHORT).show();
                    return;
                }

                // checking to see if item already exists in inventory
                if (dbHandler.compareitem(itemName) == true){
                    Toast.makeText(SupplierActivity.this, "Item already exists in inventory", Toast.LENGTH_SHORT).show();
                    return;
                }

                // method to add item and price to DB
                dbHandler.addItem(itemName, itemPrice);

                //toast message to let user know inventory was updated
                Toast.makeText(SupplierActivity.this, "Item has been added to inventory.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                priceEdt.setText("");
            }
        });

        // on click listener for our editItem method from DBHandler
        editItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // gets data from all editText fields
                String itemName =  findNameEdt.getText().toString();
                String itemPrice = changePriceEdt.getText().toString();


                // checks to see if editText is empty
                if (itemName.isEmpty() && itemPrice.isEmpty()) {
                    Toast.makeText(SupplierActivity.this, "Please fill in all the forms", Toast.LENGTH_SHORT).show();
                    return;
                }

                // checking to see if item already exists in inventory
                if (dbHandler.compareitem(itemName) == false){
                    Toast.makeText(SupplierActivity.this, "Item doesn't exist in inventory", Toast.LENGTH_SHORT).show();
                    return;
                }

                // method to add item and price to DB
                dbHandler.editItem(itemName, itemPrice);

                // toast message to let user know inventory was updated
                Toast.makeText(SupplierActivity.this, "Item price has been updated in the inventory.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                priceEdt.setText("");
            }
        });

        deleteItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // gets data from all editText fields
                String itemName =  deleteItemEdt.getText().toString();


                // checks to see if editText is empty
                if (itemName.isEmpty()) {
                    Toast.makeText(SupplierActivity.this, "Please fill in the form", Toast.LENGTH_SHORT).show();
                    return;
                }

                // checking to see if item exists in inventory
                if (dbHandler.compareitem(itemName) == false){
                    Toast.makeText(SupplierActivity.this, "Item doesn't exist in inventory", Toast.LENGTH_SHORT).show();
                    return;
                }

                // method to add item and price to DB
                dbHandler.deleteItem(itemName);

                // toast message to let user know inventory was updated
                Toast.makeText(SupplierActivity.this, "Item has been removed from inventory.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                priceEdt.setText("");
            }
        });

    }


}