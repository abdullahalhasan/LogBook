package com.abdullahalhasan.logbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ABDULLAH AL HASAN on 7/15/2016.
 */
public class Login extends AppCompatActivity {

    UserManager userManager;
    EditText emailET;
    EditText passwordET;
    TextView registerTV;
    CheckBox rememberMeCB;

    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailET = (EditText) findViewById(R.id.emailLoginET);
        passwordET = (EditText) findViewById(R.id.passwordLoginET);
        registerTV = (TextView) findViewById(R.id.registerTV);
        rememberMeCB = (CheckBox) findViewById(R.id.checkBox);

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(Login.this,Register.class);
                startActivity(registerActivity);
            }
        });

        SharedPreferences preferences = getSharedPreferences("RememberMe", MODE_PRIVATE);
        String email = preferences.getString("EMAIL",DEFAULT);
        String password = preferences.getString("PASSWORD",DEFAULT);

        if(emailET.equals(DEFAULT) || passwordET.equals(DEFAULT)) {

            emailET.getText().clear();
            passwordET.getText().clear();
        }
        else {
            emailET.setText(email);
            passwordET.setText(password);
        }
    }

    public void login(View view) {
        String userEmail = emailET.getText().toString();
        String userPassword = passwordET.getText().toString();

        boolean loggedin = userManager.searchPassword(userPassword,userEmail);


        if (rememberMeCB.isChecked()) {
            SharedPreferences preferences = getSharedPreferences("RememberMe", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            String email = emailET.getText().toString();
            String password = passwordET.getText().toString();

            editor.putString("EMAIL", email);
            editor.putString("PASSWORD", password);
            editor.commit();

        }
        else {

            if (loggedin) {

                Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
                Intent mainActivity = new Intent(this, MainActivity.class);
                startActivity(mainActivity);
                finish();

            } else if (userEmail.matches("") || userPassword.equals("")) {
                Toast.makeText(this, "Please Fillup Empty Fields", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Email & Password mismatch!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
