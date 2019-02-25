package com.example.animehousedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class weather extends AppCompatActivity {

    TextView resultTimezone;
    TextView resultDiscr;
    TextView resulttemp;
    Button searchbtn;
    EditText searchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        resultTimezone = (TextView) findViewById(R.id.resultTimezone);
        resultDiscr = (TextView) findViewById(R.id.resultDiscr);
        resulttemp = (TextView) findViewById(R.id.resulttemp);
        searchbtn = (Button) findViewById(R.id.searchbtn);
        searchData = (EditText) findViewById(R.id.searchData);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = searchData.getText().toString();
                if (!data.isEmpty()) {
                    String url = "https://api.weatherbit.io/v2.0/current/current?city=" + data + "&key=349811dfbb584188ab4a82a0c8832e9e";

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                            (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    //anName.setText("Response: " + response.toString());

                                    //timezone -- description - temp
                                    try {
                                        JSONArray jr = response.getJSONArray("data");
                                        //str = str.replaceAll("[\\[\\]\\(\\)]", "");
                                        JSONObject ob = jr.getJSONObject(0);
                                        String str = "";
                                        JSONObject object = ob.getJSONObject("weather");

                                        str = ob.getString("timezone");
                                        resultTimezone.setText(str);

                                        str = ob.getString("temp") ;
                                        resulttemp.setText(str);

                                        str = object.getString("description");
                                        resultDiscr.setText(str);

                                        // Adds the data string to the TextView "results"

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
                                    Toast.makeText(weather.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            });

                    // Access the RequestQueue through your singleton class.
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
                } else {
                    Toast.makeText(weather.this, "Enter valid data ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
