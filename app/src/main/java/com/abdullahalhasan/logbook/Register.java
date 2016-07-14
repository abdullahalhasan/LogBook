package com.abdullahalhasan.logbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ABDULLAH AL HASAN on 7/15/2016.
 */
public class Register extends AppCompatActivity {
    EditText nameET;
    EditText emailET;
    EditText passwordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        nameET = (EditText) findViewById(R.id.nameRegisterET);
        emailET = (EditText) findViewById(R.id.emailRegisterET);
        passwordET = (EditText) findViewById(R.id.passwordRegisterET);

    }

    public void signup(View view) {
        SharedPreferences preferences = getSharedPreferences("RegisterPreferences", MODE_PRIVATE);
        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name +email + password + "data",name + "\n" +email + "\n" + password);
        editor.commit();

        Intent loginActivity = new Intent(this,Login.class);
        startActivity(loginActivity);
        finish();
    }
}
