package com.example.animehousedemo2;

public class search_item {

    private String title ;
    private String synopsis ;
    private int score;
    private String image_url;
    private String type;
    private String date;
    private String url;

    public search_item(String title, String synopsis, int score, String image_url, String type, String date, String url) {
        this.title = title;
        this.synopsis = synopsis;
        this.score = score;
        this.image_url = image_url;
        this.type = type;
        this.date = date;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
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
}
