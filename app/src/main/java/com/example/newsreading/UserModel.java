package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import java.io.Serializable;

public class UserModel implements Serializable {

    // UsersModel Elements: id, username, password, userTopic
    private String id;
    private String username;
    private String password;
    private String userTopic;

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserTopic() {
        return userTopic;
    }
    public void setUserTopic(String userTopic) {
        this.userTopic = userTopic;
    }
}
