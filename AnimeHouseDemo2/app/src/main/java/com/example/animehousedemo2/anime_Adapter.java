package com.example.animehousedemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class anime_Adapter extends ArrayAdapter<anime> {


    public anime_Adapter(Context context, int resource, ArrayList<anime> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.anime_item, parent, false);
        }

        ImageView animePhoto = (ImageView) convertView.findViewById(R.id.animePhoto);
        TextView animeName = (TextView) convertView.findViewById(R.id.animeName);

        anime Anime = getItem(position);


        new loadPhotoURL(animePhoto).execute(Anime.getAnimePhoto());

        //animePhoto.setImageResource(Anime.getAnimePhoto());
        animeName.setText(Anime.getAnimeName());

        return convertView;
    }
}


/*    //class for GETTING PHOTO
    public class loadPhoto extends AsyncTask<String ,Void,Bitmap> {



}*/
