package com.example.listdemo;

import android.graphics.Bitmap;

public class eps {
    private String epsName ;
    private int epsNum;
    private String animePhoto;

    public eps(){}


    public eps (String EpsName  , int EpsNum , String photo){

        epsName = EpsName;
        epsNum = EpsNum;
        animePhoto= photo;
    }

    public String getEpsName() {
        return epsName;
    }

    public int getEpsNum() {
        return epsNum;
    }

    public String getAnimePhoto() {
        return animePhoto;
    }

}
