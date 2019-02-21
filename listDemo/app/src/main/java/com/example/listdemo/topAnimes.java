package com.example.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class topAnimes extends AppCompatActivity {

    private TextView anName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        anName = findViewById(R.id.animeName2);
        anName.setText("Top 10 upcoming animes");

        ArrayList<tob_item> TopList = new ArrayList<>();

        TopList.add(new tob_item("Death Note",1,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","12/12/2018"));
        TopList.add(new tob_item("Hunter X Hunter",2,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","11/1/2018"));
        TopList.add(new tob_item("Death note",3,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","18/3/2018"));
        TopList.add(new tob_item("Hunter X Hunter",4,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","31/5/2018"));
        TopList.add(new tob_item("Death note",5,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","10/4/2018"));
        TopList.add(new tob_item("Hunter X Hunter",6,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","8/9/2018"));
        TopList.add(new tob_item("Death note",7,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","1/8/2018"));
        TopList.add(new tob_item("Hunter X Hunter",8,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","1/8/2018"));
        TopList.add(new tob_item("Death note",9,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","1/8/2018"));
        TopList.add(new tob_item("Hunter X Hunter",10,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","1/8/2018"));

        ListView listView = (ListView) findViewById(R.id.animeList);
        listView.setAdapter(new top_Adapter(this,0,TopList));
    }
}
