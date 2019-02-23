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
import com.example.animehousedemo2.search_item;
public class search_result extends AppCompatActivity {
    ListView listView;
    ArrayList<search_item> searchList;
    search_item search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        listView = (ListView) findViewById(R.id.searchList);

        searchList = new ArrayList<>();

        //String input = this.getIntent().getExtras().getString("title");
        String Url = "https://api.jikan.moe/v3/search/anime/?q="+this.getIntent().getExtras().getString("title")+"&page=1";

        getData(Url);

        //Toast.makeText(this,"the title: "+ input,Toast.LENGTH_LONG).show();

    }


    public void getData(String Url) {

    }

}
