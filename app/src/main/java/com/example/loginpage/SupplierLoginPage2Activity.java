package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SupplierLoginPage2Activity extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    DBSupplierLogin DB;
    private TextView Info;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_login_page2);

        // title
        getSupportActionBar().setTitle("Supplier Login");

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.etUsernameS);
        password = (EditText) findViewById(R.id.etPasswordS);
        Info = (TextView) findViewById(R.id.tvinfo);
        btnlogin = (Button) findViewById(R.id.btnLoginS);
        DB = new DBSupplierLogin(this);

        Info.setText("Number of attempts remaining: 3");

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(SupplierLoginPage2Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(SupplierLoginPage2Activity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), SupplierMainPageActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SupplierLoginPage2Activity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                        counter--;
                        Info.setText("Number of attempts remaining: " + String.valueOf(counter));
                        if(counter == 0) {
                            btnlogin.setEnabled(false); //disable button for security purposes
                        }
                    }
                }


            }
        });

    }
}