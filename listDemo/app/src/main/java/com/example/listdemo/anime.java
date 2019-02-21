package com.example.listdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class anime {

    private String animeName ;
    private String animePhoto;

    public anime(){}

    public anime (String animeNamee  ,String animePhotoo){

        animeName = animeNamee;
        animePhoto = animePhotoo;
    }

    public String getAnimeName() {
        return animeName;
    }

    public String getAnimePhoto() {
        return animePhoto;
    }
}
