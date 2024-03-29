package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeLoginPage2Activity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signin;
    DBEmployeeLogin DB;
    private TextView Info;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login_page2);

        // title
        getSupportActionBar().setTitle("Employee Login");

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username= (EditText) findViewById(R.id.EmployeeUsername);
        password= (EditText) findViewById(R.id.EmployeePass2);
        Info = (TextView) findViewById(R.id.tvinfo);
        signin = (Button) findViewById(R.id.btnEmployeelogin);
        DB=new DBEmployeeLogin(this);

        Info.setText("Number of attempts remaining: 3");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(EmployeeLoginPage2Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(EmployeeLoginPage2Activity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), EmployeeMainPageActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(EmployeeLoginPage2Activity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                        counter--;
                        Info.setText("Number of attempts remaining: " + String.valueOf(counter));
                        if(counter == 0) {
                            signin.setEnabled(false); //disable button for security purposes
                        }
                    }
                }
            }
        });


    }
}