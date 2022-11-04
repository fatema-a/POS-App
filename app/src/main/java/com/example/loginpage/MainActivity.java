package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Info.setText("Number of attempts remaining: 3");

        //reads the data entered by the user
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });


    }

    //===============================
    //Main page selection: First activity
    //===============================

    // to be implemented

    //===============================
    //Login sections: Second activity
    //===============================

    // For employee login
    private void validate(String userName, String userPassword){
        if((userName == "Employee") && (userPassword == "1234")){
            //Connecting the login page to the new app page which will be the employee main page
            Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
            startActivity(intent);
        }
        //in case wrong password input
        else{
            counter--;
            Info.setText("Number of attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false); //disable button for security purposes


            }

        }

    }
}