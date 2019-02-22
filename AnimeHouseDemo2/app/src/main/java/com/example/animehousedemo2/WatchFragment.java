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

import java.util.ArrayList;


public class WatchFragment extends Fragment {

    ListView listView;
    ArrayList<eps> epsList;

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

        epsList.add(new eps("Another", 1, "https://myanimelist.cdn-dena.com/images/anime/4/75509l.jpg","https://myanimelist.net/anime/90/Mobile_Suit_Gundam_Wing/episode/1","https://myanimelist.net/forum/?topicid=50612"));
        epsList.add(new eps("Gintama", 2, "https://myanimelist.cdn-dena.com/images/anime/3/36969l.jpg","https://myanimelist.net/anime/100/Shin_Shirayuki-hime_Densetsu_Prétear/episode/1","https://myanimelist.net/forum/?topicid=203354"));


        listView.setAdapter(new anime_Adapter(v.getContext(), 0, animeList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob = listView.getItemAtPosition(position);
                anime aa = (anime) ob;

                listView.setAdapter(new eps_Adapter(view.getContext(),0,epsList));

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

}
