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

        String url = Url;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //anName.setText("Response: " + response.toString());

                        //title -- score - image_url - type - start_date - url - synopsis
                        try {
                            JSONArray jr = response.getJSONArray("results");

                            for (int i = 0; i < jr.length(); i++) {
                                search = new search_item();
                                JSONObject jsonObject = jr.getJSONObject(i);

                                search.setTitle(jsonObject.getString("title"));
                                search.setScore(jsonObject.getInt("score"));
                                search.setUrl(jsonObject.getString("url"));
                                search.setDate(jsonObject.getString("start_date"));
                                search.setImage_url(jsonObject.getString("image_url"));
                                search.setType(jsonObject.getString("type"));
                                search.setSynopsis(jsonObject.getString("synopsis"));
                                searchList.add(search);
                                System.out.println(searchList.get(i).getTitle());
                            }

                            // Adds the data string to the TextView "results"
                            listView.setAdapter(new search_Adapter(getApplicationContext(),0,searchList));

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
                        Toast.makeText(search_result.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    

}
