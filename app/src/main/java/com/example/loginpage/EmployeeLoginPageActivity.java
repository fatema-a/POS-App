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

public class EmployeeLoginPageActivity extends AppCompatActivity {

    //declarations
   private EditText username;
    private EditText password;
    private EditText repassword;
    private Button signup;
    private Button signin;
    DBEmployeeLogin DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_employee);

        // title
        getSupportActionBar().setTitle("Employee Registration");

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        password= (EditText) findViewById(R.id.EmployeePass);
        username=(EditText) findViewById(R.id.username);
        repassword=(EditText) findViewById(R.id.ReEmployeePass);
        signup=(Button) findViewById(R.id.EmployeeRegister);
        signin=(Button) findViewById(R.id.btnEmployeeSignIn);
        DB = new DBEmployeeLogin(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(EmployeeLoginPageActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(EmployeeLoginPageActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),EmployeeLoginPage2Activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(EmployeeLoginPageActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(EmployeeLoginPageActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(EmployeeLoginPageActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeLoginPage2Activity.class);
                startActivity(intent);

            }
        });

    }
}