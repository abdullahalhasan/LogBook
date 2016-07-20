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


    EditText nameET;
    EditText emailET;
    EditText passwordET;
    EditText confirmPasswordET;

    String name;
    String email;
    String password;


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
        if (passwordET.equals(passwordET)) {

            name = nameET.getText().toString();
            email = emailET.getText().toString();
            password = passwordET.getText().toString();

            User newUser = new User(name,email, password);
            userManager.addUser(newUser);


            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();

            Intent loginActivity = new Intent(this, Login.class);
            startActivity(loginActivity);
            finish();
        }
        else if(nameET.equals("")||emailET.equals("")||passwordET.equals("")||confirmPasswordET.equals("")) {
            Toast.makeText(this, "Please Fillup Empty Fields", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Password Mismatch!", Toast.LENGTH_LONG).show();
        }
    }
}
