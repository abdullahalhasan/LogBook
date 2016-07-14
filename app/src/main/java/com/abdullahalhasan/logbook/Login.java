package com.abdullahalhasan.logbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ABDULLAH AL HASAN on 7/15/2016.
 */
public class Login extends AppCompatActivity {
    EditText emailET;
    EditText passwordET;
    TextView registerTV;

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
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        SharedPreferences preferences = getSharedPreferences("RegisterPreferences",MODE_PRIVATE);
        String userDetails = preferences.getString(email + password + "data","Email and Password Mismatch");
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("dispaly",userDetails);
        editor.commit();

        Intent mainActivity = new Intent(this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
