package com.example.animehousedemo2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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


public class WatchFragment extends Fragment {

    ListView listView;
    ArrayList<eps> epsList;
    eps epsd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_watch, container, false);
        listView = (ListView) v.findViewById(R.id.animeList);


        ArrayList<anime> animeList = new ArrayList<>();
        animeList.add(new anime("90", "mobile suit gundam wing", "https://myanimelist.cdn-dena.com/images/anime/11/8429l.jpg"));
        animeList.add(new anime("100", "Shin Shirayuki", "https://myanimelist.cdn-dena.com/images/anime/11/5244l.jpg"));
        animeList.add(new anime("1000", "Uchuu Kaizoku Captain Herlock", "https://myanimelist.cdn-dena.com/images/anime/4/21236l.jpg"));
        animeList.add(new anime("123", "fushigi yuugi", "https://myanimelist.cdn-dena.com/images/anime/10/7608l.jpg"));
        animeList.add(new anime("124", "fushigi yuugi eikoden", "https://myanimelist.cdn-dena.com/images/anime/6/3416l.jpg"));
        animeList.add(new anime("9989", "Ano Hi Mita Hana no Namae wo Bokutachi wa Mada Shiranai", "https://myanimelist.cdn-dena.com/images/anime/5/29808l.jpg"));
        animeList.add(new anime("1289", "Kidou Keisatsu Patlabor", "https://myanimelist.cdn-dena.com/images/anime/10/23500l.jpg"));
        animeList.add(new anime("11111", "Another", "https://myanimelist.cdn-dena.com/images/anime/4/75509l.jpg"));
        animeList.add(new anime("9969", "Gintama", "https://myanimelist.cdn-dena.com/images/anime/3/36969l.jpg"));


        epsList = new ArrayList<>();

        listView.setAdapter(new anime_Adapter(v.getContext(), 0, animeList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob = listView.getItemAtPosition(position);
                anime aa = (anime) ob;
                String Url = "https://api.jikan.moe/v3/anime/"+aa.getKey()+"/episodes/";
                getData(Url, aa.getAnimePhoto());
                /*//INTENT OBJ
                Intent i = new Intent(getActivity().getBaseContext(),
                        the_rest_apis.class);

                //PACK DATA
                i.putExtra("key", aa.getKey());
                i.putExtra("key", aa.getAnimePhoto());
                //START ACTIVITY
                getActivity().startActivity(i);
                //String myStr = getArguments().getString("my_key");
            */


            }
        });

        setHasOptionsMenu(true);
        return v;
    }

    public void getData(String Url, final String img) {

        String url = Url;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        //title -- episode_id - forum_url - video_url

                        try {

                            JSONArray jr = response.getJSONArray("episodes");

                            for (int i = 0; i < 10; i++) {
                                epsd = new eps();
                                JSONObject jsonObject = jr.getJSONObject(i);

                                epsd.setTitle(jsonObject.getString("title"));
                                epsd.setEpisode_id(jsonObject.getInt("episode_id"));
                                epsd.setForum_url(jsonObject.getString("forum_url"));
                                epsd.setVideo_url(jsonObject.getString("video_url"));
                                epsd.setAnimePhoto(img);

                                epsList.add(epsd);
                                System.out.println("The data .......");
                                System.out.println(epsList.get(i).getEpsName());
                            }

                            // Adds the data string to the TextView "results"

                            listView.setAdapter(new eps_Adapter(getContext(), 0, epsList));
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
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
    }

}
