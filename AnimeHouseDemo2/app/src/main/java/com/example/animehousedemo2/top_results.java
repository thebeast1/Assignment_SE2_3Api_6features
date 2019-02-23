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

        String url = Url;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //anName.setText("Response: " + response.toString());


                        //title -- rank - img - type - date - url
                        try {

                            JSONArray jr = response.getJSONArray("top");

                            for (int i = 0; i < 10; i++) {
                                tob = new tob_item();
                                JSONObject jsonObject = jr.getJSONObject(i);

                                tob.setTitle(jsonObject.getString("title"));
                                tob.setRank(jsonObject.getInt("rank"));
                                tob.setUrl(jsonObject.getString("url"));
                                tob.setDate(jsonObject.getString("start_date"));
                                tob.setImage_url(jsonObject.getString("image_url"));
                                tob.setType(jsonObject.getString("type"));
                                TopList.add(tob);
                                System.out.println("The data .......");
                                System.out.println(TopList.get(i).getAnimeName());
                            }

                            // Adds the data string to the TextView "results"
                            //anName.setText(data);

                            listView.setAdapter(new top_Adapter(getApplicationContext(), 0, TopList));

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
                        Toast.makeText(top_results.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    

}

}