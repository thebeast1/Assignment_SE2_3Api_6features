package com.example.animehousedemo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class the_rest_apis extends AppCompatActivity {

    Button transBtn;
    Button weatherBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_rest_apis);

        transBtn = (Button) findViewById(R.id.transBtn);
        weatherBtn = (Button) findViewById(R.id.weatherBtn);

        transBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),translator.class);
                startActivity(intent);
            }
        });
        weatherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),weather.class);
                startActivity(intent);
            }
        });



    }
}
