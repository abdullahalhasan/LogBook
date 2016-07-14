package com.abdullahalhasan.logbook;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        SharedPreferences preferences = getSharedPreferences("RegisterPreferences",MODE_PRIVATE);
        String dispaly = preferences.getString("display","");

        textView.setText(dispaly);
    }
}
