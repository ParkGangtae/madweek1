package com.example.myapplication;

public class RankingData {
    private String title;
    private float avg_score;

    public RankingData(String title, float avg_score){
        this.title = title;
        this.avg_score = avg_score;
    }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }
    public float getAvg_score(){ return avg_score; }
    public void setAvg_score(float avg_score){ this.avg_score = avg_score; }

}
