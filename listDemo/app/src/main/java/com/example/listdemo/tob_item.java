package com.example.listdemo;

import java.util.Date;

public class tob_item {

    private String animeName ;
    private int animeRank;
    private String animePhoto;
    private String type;
    private String date;

    public tob_item(String animeName, int animeRank, String animePhoto, String type, String date) {
        this.animeName = animeName;
        this.animeRank = animeRank;
        this.animePhoto = animePhoto;
        this.type = type;
        this.date = date;
    }

    public String getAnimeName() {
        return animeName;
    }

    public int getAnimeRank() {
        return animeRank;
    }

    public String getAnimePhoto() {
        return animePhoto;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
