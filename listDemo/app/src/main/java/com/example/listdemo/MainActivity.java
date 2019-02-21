package com.example.listdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private TextView anName;
    private LinearLayout linearLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.lin);
        anName = findViewById(R.id.animeName2);

        linearLayout.setVisibility(View.GONE);
        anName.setVisibility(View.GONE);


        ArrayList<anime> animeList = new ArrayList<>();

        animeList.add(new anime("Hunter x Hunter","https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg"));
        animeList.add(new anime("frgt hyh","https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg"));
        animeList.add(new anime("awer moja ","https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg"));
        animeList.add(new anime("vbnm m","https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg"));
        animeList.add(new anime("zxcvf ","https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg"));
        animeList.add(new anime("defrr bb","https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg)"));
        animeList.add(new anime("rrt bgh","https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg"));
        animeList.add(new anime("Death Note","https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        final ListView listView = (ListView) findViewById(R.id.animeList);
        listView.setAdapter(new anime_Adapter(this,0,animeList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob = listView.getItemAtPosition(position);
                anime aa = (anime)ob;
                Intent t =new Intent(MainActivity.this , anime_episodes.class);
                t.putExtra("VALUE", aa.getAnimeName());
                t.putExtra("photo", aa.getAnimePhoto());
                startActivity(t);
            }
        });
    }

       public void dd(View view) {
        Intent t =new Intent(MainActivity.this , topAnimes.class);
        startActivity(t);
    }
}
