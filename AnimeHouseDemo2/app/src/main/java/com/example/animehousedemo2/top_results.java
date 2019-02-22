package com.example.animehousedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class top_results extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_results);
        listView = (ListView) findViewById(R.id.topList);

        ArrayList<tob_item> TopList = new ArrayList<>();

        TopList.add(new tob_item("Death Note",1,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","12/12/2018","https://myanimelist.net/anime/34134/One_Punch_Man_Season_2"));
        TopList.add(new tob_item("Hunter X Hunter",2,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","11/1/2018","https://myanimelist.net/anime/38408/Boku_no_Hero_Academia_4th_Season"));
        TopList.add(new tob_item("Death note",3,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","18/3/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));
        TopList.add(new tob_item("Hunter X Hunter",4,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","31/5/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));
        TopList.add(new tob_item("Death note",5,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","10/4/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));
        TopList.add(new tob_item("Hunter X Hunter",6,"https://m.media-amazon.com/images/M/MV5BZjNmZDhkN2QtNDYyZC00YzJmLTg0ODUtN2FjNjhhMzE3ZmUxXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_UX182_CR0,0,182,268_AL_.jpg","Tv","8/9/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));
        TopList.add(new tob_item("Death note",7,"https://i.pinimg.com/originals/67/f8/37/67f83752898a437760a74970d5cb9a84.jpg","Tv","1/8/2018","https://myanimelist.net/anime/3786/Evangelion__30_10"));
        listView.setAdapter(new top_Adapter(this,0,TopList));
        Toast.makeText(this,"the data: "+ this.getIntent().getExtras().getString("key"),Toast.LENGTH_LONG).show();
    }


    String data ="";
    public void ee (){
        String url = "https://api.jikan.moe/v3/top/anime/1/tv";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //anName.setText("Response: " + response.toString());

                        try {

                            JSONArray jr = response.getJSONArray("top");

                            for (int i = 0; i < jr.length(); i++) {
                                JSONObject jsonObject = jr.getJSONObject(i);

                                String title = jsonObject.getString("title");
                                String eps = jsonObject.getString("episodes");

                                data += title+"  "+eps+"\n";
                            }
                            // Adds the data string to the TextView "results"
                            anName.setText(data);
                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Toast.makeText(MainActivity.this,"erererr",Toast.LENGTH_SHORT).show();
                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

}