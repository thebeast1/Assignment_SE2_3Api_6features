package com.example.animehousedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class the_rest_apis extends AppCompatActivity {

    TextView testText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_rest_apis);

        testText = (TextView) findViewById(R.id.test);


        //testText.setText(this.getIntent().getExtras().getString("key"));
    }
}
