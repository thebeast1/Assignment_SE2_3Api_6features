package com.example.animehousedemo2;

public class eps {
    private String title;
    private int episode_id;
    private String animePhoto;
    private String video_url;
    private String forum_url;

    public eps(){}

    public eps(String EpsName  , int EpsNum , String photo, String video_url, String forum_url){

        title = EpsName;
        episode_id = EpsNum;
        animePhoto= photo;
        this.video_url = video_url;
        this.forum_url = forum_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public void setAnimePhoto(String animePhoto) {
        this.animePhoto = animePhoto;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }


    public String getForum_url() {
        return forum_url;
    }

    public void setForum_url(String forum_url) {
        this.forum_url = forum_url;
    }

    public String getEpsName() {
        return title;
    }

    public int getEpsNum() {
        return episode_id;
    }

    public String getAnimePhoto() {
        return animePhoto;
    }

}
