package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import android.app.Application;
import android.content.Context;

public class App extends Application {

    // App Elements: DatabaseHelper, SQLiteDatabase, Strings
    public static UserModel nowUser;
    private static Context appContext;
    public final static String REFRESH_NEWS = "refresh.news";
    public final static String REFRESH_LOGIN = "refresh.login";

    // onCreate
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    // getContext
    public static Context getContext() {
        return appContext;
    }
}
