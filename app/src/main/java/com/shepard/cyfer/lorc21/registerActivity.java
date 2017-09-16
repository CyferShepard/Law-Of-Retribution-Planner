package com.shepard.cyfer.lorc21;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registerActivity extends AppCompatActivity {

    EditText rUser, rPass, rcPass ,rEmail;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rUser = (EditText)findViewById(R.id.regUser);
        rPass = (EditText)findViewById(R.id.txtRegP);
        rEmail = (EditText)findViewById(R.id.txtEmailR);
        rcPass = (EditText)findViewById(R.id.regCP);
    }

    public void ret()
    {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }


    public void OnRegister(View view) {
        String username = rUser.getText().toString();
        String password = rPass.getText().toString();
        String email = rEmail.getText().toString();
        String cp = rcPass.getText().toString();

      //  BackgroundWorker emc = new BackgroundWorker(this);
       // emc.execute("emailc", email);
      //  BackgroundWorker userc = new BackgroundWorker(this);
      //  userc.execute("userc", email);

       String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

// onClick of button perform this simplest code.
        if (email.matches(emailPattern))
        {
            if (!username.equals("") && !password.equals("") && !email.equals("")) {
                if (password.equals(cp)) {
                    String type = "register";
                    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                    backgroundWorker.execute(type, username, password, email);




                } else {
                    alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("Error!");
                    alertDialog.setMessage("Passwors Do Not Match.");
                    alertDialog.show();
                }
            } else {
                alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("Please Fill in all of the Required Fields.");
                alertDialog.show();
            }


        }
        else
        {
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error!");
            alertDialog.setMessage("Invalid Email format.");
            alertDialog.show();
        }
        }
    }
