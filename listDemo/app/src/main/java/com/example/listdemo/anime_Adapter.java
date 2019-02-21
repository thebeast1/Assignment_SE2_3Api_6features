package com.example.listdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
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
