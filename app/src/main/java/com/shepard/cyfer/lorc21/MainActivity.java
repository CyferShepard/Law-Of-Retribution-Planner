package com.shepard.cyfer.lorc21;


import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    AlertDialog alertDialog;
    EditText UsernameEt, PasswordEt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);

    }

    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        if(!username.equals("") && !password.equals("")) {
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);

            backgroundWorker.execute(type, username, password);

        }else
        {
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error!");
            alertDialog.setMessage("Please Fill in all of the Required Fields.");
            alertDialog.show();
        }
    }


    public void OnSwitchR(View view)
    {
        Intent intent = new Intent(MainActivity.this, registerActivity.class);
        startActivityForResult(intent, 1);
    }

   public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Success!");
            alertDialog.setMessage("Registration Complete.");
            alertDialog.show();
        }
    }
}
