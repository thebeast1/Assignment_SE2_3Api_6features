package com.example.animehousedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class translator extends AppCompatActivity {

    Spinner spinF, spinT;
    Button btn;
    EditText textArea_information, textArea_translated;
    int tLang = 0, dLang = 0;
    String[] code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        code = new String[]{"en", "ar", "nl", "el", "it", "ga", "es", "ko", "zh", "ja", "de"};

        spinF = (Spinner) findViewById(R.id.spinF);
        spinT = (Spinner) findViewById(R.id.spinT);
        btn = (Button) findViewById(R.id.Tbtn);
        textArea_information = (EditText) findViewById(R.id.textArea_information);
        textArea_translated = (EditText) findViewById(R.id.textArea_translated);

        spinF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dLang = parent.getPositionForView(view);
             //   Toast.makeText(getApplicationContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                tLang = parent.getPositionForView(view);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), dLang + "   " + tLang, Toast.LENGTH_SHORT).show();
                String data = textArea_information.getText().toString();
                if (!data.isEmpty() && tLang != dLang) {
                    String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20190223T143546Z.4d80aa05815361ac.14e646f80fe614950303cbec9728575e98772bc6&text=" + data+"&lang=" + code[dLang] + "-" + code[tLang] + "";

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                            (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    //anName.setText("Response: " + response.toString());

                                    //title -- score - image_url - type - start_date - url - synopsis
                                    try {
                                        JSONArray jr = response.getJSONArray("text");
                                        String str = jr.toString();
                                        str = str.replaceAll("[\\[\\]\\(\\)]", "");
                                        textArea_translated.setText(str);

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
                                    Toast.makeText(translator.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            });

                    // Access the RequestQueue through your singleton class.
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
                }else {
                    Toast.makeText(translator.this, "Enter valid data or choose lang", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}