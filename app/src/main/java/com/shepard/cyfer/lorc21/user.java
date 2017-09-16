package com.shepard.cyfer.lorc21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class user extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String s= getIntent().getStringExtra("username");
        String type = "fcount";
      //  BackgroundWorker backgroundWorker = new BackgroundWorker(this);

       // backgroundWorker.execute(type, "CYFER");

    }




}
