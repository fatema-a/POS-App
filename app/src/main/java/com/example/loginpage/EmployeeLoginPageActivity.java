package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EmployeeLoginPageActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private ImageButton Back;
    private Button Login;

    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_employee);

        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Back = (ImageButton)findViewById(R.id.ImbtnBack);

        Info.setText("Number of attempts remaining: 3");


        //reads the data entered by the user
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrevious();
            }
        });
    }


    //===============================
    //Login sections: Second activity
    //===============================

    // For employee login
    private void validate(String userName, String userPassword){
        if((userName.equals("Employee") && (userPassword.equals( "1234")))){
            //Connecting the login page to the new app page which will be the employee main page
            Intent intent = new Intent(EmployeeLoginPageActivity.this, EmployeeMainPageActivity.class);
            startActivity(intent);
        }

        //in case wrong input
        else{
            counter--;
            Info.setText("Number of attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false); //disable button for security purposes


            }

        }

    }

    public void openPrevious(){
        Intent intent = new Intent(EmployeeLoginPageActivity.this, MainPageActivity.class);
        startActivity(intent);
    }
}