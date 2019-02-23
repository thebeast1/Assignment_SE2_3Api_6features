package com.example.animehousedemo2;

public class tob_item {

    private String title ;
    private int rank;
    private String image_url;
    private String type;
    private String date;
    private String url;

    public tob_item(String animeName, int animeRank, String animePhoto, String type, String date , String url) {
        this.title = animeName;
        this.rank = animeRank;
        this.image_url = animePhoto;
        this.type = type;
        this.date = date;
        this.url = url;
    }

    public tob_item(){

    };

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAnimeName() {
        return title;
    }

    public int getAnimeRank() {
        return rank;
    }

    public String getAnimePhoto() {
        return image_url;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
