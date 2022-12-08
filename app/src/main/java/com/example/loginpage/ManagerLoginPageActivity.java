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

public class ManagerLoginPageActivity extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup, signin;
    DBManagerLogin DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login_page);

        // title
        getSupportActionBar().setTitle("Manager Registration");

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.managerUsername);
        password = (EditText) findViewById(R.id.managerPassword);
        repassword = (EditText) findViewById(R.id.managerRepassword);
        signup = (Button) findViewById(R.id.managerSignup);
        signin = (Button) findViewById(R.id.managerSignin);
        DB = new DBManagerLogin(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(ManagerLoginPageActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(ManagerLoginPageActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),ManagerLoginPage2Activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(ManagerLoginPageActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(ManagerLoginPageActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ManagerLoginPageActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ManagerLoginPage2Activity.class);
                startActivity(intent);
            }
        });

    }
}
