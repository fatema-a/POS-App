package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SupplierLoginPageActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText repassword;
    private Button login;
    private Button signup;
    DBSupplierLogin DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_login_page);

        // title
        getSupportActionBar().setTitle("Supplier Registration");

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText)findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        login = (Button)findViewById(R.id.btnLogin);
        DB = new DBSupplierLogin(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SupplierLoginPageActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(SupplierLoginPageActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),SupplierLoginPage2Activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SupplierLoginPageActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SupplierLoginPageActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SupplierLoginPageActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SupplierLoginPage2Activity.class);
                startActivity(intent);
            }
        });



    }

}