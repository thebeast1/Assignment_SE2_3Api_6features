package com.example.animehousedemo2;

public class anime {

    private String animeName;
    private String animePhoto;
    private String key;

    public anime() {
    }

    public anime(String key,String animeName, String animePhoto) {
        this.animeName = animeName;
        this.animePhoto = animePhoto;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public void setAnimePhoto(String animePhoto) {
        this.animePhoto = animePhoto;
    }

    public String getAnimeName() {
        return animeName;
    }

    public String getAnimePhoto() {
        return animePhoto;
    }
}
