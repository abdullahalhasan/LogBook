package com.abdullahalhasan.logbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ABDULLAH AL HASAN on 7/15/2016.
 */
public class Register extends AppCompatActivity {

    UserManager userManager;
    User newUser;


    EditText nameET;
    EditText emailET;
    EditText passwordET;
    EditText confirmPasswordET;

    String name;
    String email;
    String password;
    String confirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        nameET = (EditText) findViewById(R.id.nameRegisterET);
        emailET = (EditText) findViewById(R.id.emailRegisterET);
        passwordET = (EditText) findViewById(R.id.passwordRegisterET);
        confirmPasswordET = (EditText) findViewById(R.id.confirmPasswordRegisterET);

    }

    public void register(View view) {

        name = nameET.getText().toString().trim();
        email = emailET.getText().toString().trim();
        password = passwordET.getText().toString().trim();
        confirmPassword = confirmPasswordET.getText().toString().trim();

        if (confirmPassword.equals(password)) {

            newUser = new User(name, email, password);
            userManager = new UserManager(this);
            userManager.addUser(newUser);

            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();

            Intent loginActivity = new Intent(this, Login.class);
            startActivity(loginActivity);
            finish();
        } else {
            Toast.makeText(this, "Password Mismatch!", Toast.LENGTH_LONG).show();
        }

    }
}
