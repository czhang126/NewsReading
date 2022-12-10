package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import java.io.Serializable;

public class NewsModel implements Serializable{

    // NewsModel Elements: id, newsTopic, title, content, like
    private String id;
    private String newsTopic;
    private String title;
    private String content;
    private boolean like;

    // Constructor
    public NewsModel(String id, String newsTopic, String title, String content) {
        this.id = id;
        this.newsTopic = newsTopic;
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNewsTopic() {
        return newsTopic;
    }
    public void setNewsTopic(String newsTopic) {
        this.newsTopic = newsTopic;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isLike() { return like; }
    public void setLike(boolean like) { this.like = like; }

    // getImageById
    public int getImageById() {
        switch (id) {
            case "1": return R.drawable.art_01;
            case "2": return R.drawable.art_02;
            case "3": return R.drawable.art_03;
            case "4": return R.drawable.art_04;
            case "5": return R.drawable.art_05;
            case "6": return R.drawable.art_06;
            case "7": return R.drawable.sport_01;
            case "8": return R.drawable.sport_02;
            case "9": return R.drawable.sport_03;
            case "10": return R.drawable.sport_04;
            case "11": return R.drawable.sport_05;
            case "12": return R.drawable.sport_06;
            case "13": return R.drawable.bussiness_01;
            case "14": return R.drawable.bussiness_02;
            case "15": return R.drawable.bussiness_03;
            case "16": return R.drawable.bussiness_04;
            case "17": return R.drawable.bussiness_05;
            case "18": return R.drawable.bussiness_06;
            case "19": return R.drawable.science_01;
            case "20": return R.drawable.science_02;
            case "21": return R.drawable.science_03;
            case "22": return R.drawable.science_04;
            case "23": return R.drawable.science_05;
            case "24": return R.drawable.science_06;
            case "25": return R.drawable.technology_01;
            case "26": return R.drawable.technology_02;
            case "27": return R.drawable.technology_03;
            case "28": return R.drawable.technology_04;
            case "29": return R.drawable.technology_05;
            case "30": return R.drawable.technology_06;
        }
        return R.drawable.art_01;
    }
}
