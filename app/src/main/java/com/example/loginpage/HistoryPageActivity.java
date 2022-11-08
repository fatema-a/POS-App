package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HistoryPageActivity extends AppCompatActivity {

    public ImageButton Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);

        Return = (ImageButton)findViewById(R.id.IbtnReturn);

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrevious();
            }
        });

    }

    public void openPrevious(){
        Intent intent = new Intent(HistoryPageActivity.this, EmployeeMainPageActivity.class);
        startActivity(intent);
    }
}
