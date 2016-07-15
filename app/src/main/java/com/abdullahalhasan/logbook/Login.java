package com.abdullahalhasan.logbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ABDULLAH AL HASAN on 7/15/2016.
 */
public class Login extends AppCompatActivity {
    EditText emailET;
    EditText passwordET;
    TextView registerTV;

    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailET = (EditText) findViewById(R.id.emailLoginET);
        passwordET = (EditText) findViewById(R.id.passwordLoginET);
        registerTV = (TextView) findViewById(R.id.registerTV);

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(Login.this,Register.class);
                startActivity(registerActivity);
            }
        });
    }

    public void login(View view) {
        String userEmail = emailET.getText().toString();
        String userPassword = passwordET.getText().toString();

        SharedPreferences preferences = getSharedPreferences("UserData",MODE_PRIVATE);

//        SharedPreferences.Editor editor = preferences.edit();
        String savedEmail = preferences.getString("EMAIL",DEFAULT);
        String savedPassword = preferences.getString("PASSWORD",DEFAULT);
//        editor.commit();

        if (savedEmail.equals(DEFAULT) || savedPassword.equals(DEFAULT)) {

            Toast.makeText(this,"Register First",Toast.LENGTH_SHORT).show();
        }
        else if(userEmail.equals(savedEmail) && userPassword.equals(savedPassword)) {
            Toast.makeText(this,"Logged in",Toast.LENGTH_SHORT).show();
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
            finish();
        }
        else if(userEmail.equals(null) || userPassword.equals(null)) {
            Toast.makeText(this,"Enter both Email and Password!!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Email & Password mismatch!!", Toast.LENGTH_SHORT).show();
        }
    }
}
