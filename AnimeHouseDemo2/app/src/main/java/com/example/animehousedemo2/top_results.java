package com.example.animehousedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.animehousedemo2.tob_item;

public class top_results extends AppCompatActivity {
    ListView listView;
    tob_item tob = null;
    ArrayList<tob_item> TopList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_results);
        listView = (ListView) findViewById(R.id.topList);


        TopList = new ArrayList<>();

        String input = this.getIntent().getExtras().getString("key");
        String type = this.getIntent().getExtras().getString("type");

        String Url = "https://api.jikan.moe/v3/top/"+type+"/1/"+input;//"https://api.jikan.moe/v3/top/"+ type +"/1/" + input;
        getData(Url);

        //Toast.makeText(this, "the data: " + this.getIntent().getExtras().getString("key"), Toast.LENGTH_LONG).show();
    }

 public void getData(String Url) {

}

}