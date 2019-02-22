package com.example.animehousedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class search_result extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        listView = (ListView) findViewById(R.id.searchList);

        ArrayList<search_item> TopList = new ArrayList<>();

        TopList.add(new search_item("Death Note","As the Fourth Holy Grail War rages on with no clear victor in sight, the remaining Servants and their Masters are called upon by Church supervisor Risei Kotomine, in order to band together and confron...",1,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","12/12/2018","https://myanimelist.net/anime/34134/One_Punch_Man_Season_2"));
        TopList.add(new search_item("Hunter X Hunter","The story re-imagines the cast of the Fate/Zero",2,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","11/1/2018","https://myanimelist.net/anime/38408/Boku_no_Hero_Academia_4th_Season"));
        TopList.add(new search_item("Death note","The story re-imagines the cast of the Fate/Zero",3,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","18/3/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));
        TopList.add(new search_item("Hunter X Hunter","The story re-imagines the cast of the Fate/Zero",4,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","31/5/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));

        listView.setAdapter(new search_Adapter(this,0,TopList));
        Toast.makeText(this,"the title: "+ this.getIntent().getExtras().getString("title"),Toast.LENGTH_LONG).show();

    }
}
