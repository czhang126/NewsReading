package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import java.util.List;

public class TopicModel {

    // TopicModel Elements: topic, newsList
    private String topic;
    private List<NewsModel> newsList;

    // Constructor
    public TopicModel(String topic, List<NewsModel> newsList) {
        this.topic = topic;
        this.newsList = newsList;
    }

    // Getters and Setters
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public List<NewsModel> getNewsList() {
        return newsList;
    }
    public void setNewsList(List<NewsModel> newsList) {
        this.newsList = newsList;
    }
}
