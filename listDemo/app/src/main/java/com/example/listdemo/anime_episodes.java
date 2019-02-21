package com.example.listdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class anime_episodes extends AppCompatActivity {

    private int epsCounter =1;
    private TextView anName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent t = this.getIntent();
        String  s = t.getStringExtra("VALUE");
        String photo = t.getStringExtra("photo");



        anName = findViewById(R.id.animeName2);
        anName.setText(s);

        ArrayList<eps> epsList = new ArrayList<>();

        epsList.add(new eps("fight fight",epsCounter , photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));
        epsList.add(new eps("fight fight",++epsCounter, photo));



        ListView listView = (ListView) findViewById(R.id.animeList);
        listView.setAdapter(new eps_Adapter(this,0,epsList));

    }
}
