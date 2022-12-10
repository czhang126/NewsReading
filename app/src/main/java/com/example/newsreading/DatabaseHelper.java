package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import android.util.Log;
import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Create DB
    private static final String DATABASE_NAME = "NewsReading.db";
    public DatabaseHelper(@Nullable Context c) {
        super(c, DATABASE_NAME, null, 2);
    }
    private static DatabaseHelper dh;
    public static DatabaseHelper getDh() {
        if (null == dh) {
            dh = new DatabaseHelper(App.getContext());
        }
        return dh;
    }

    // onCreate and onUpgrade
    @Override
    public void onCreate(SQLiteDatabase sdb) {
        Log.i(DatabaseHelper.class.getSimpleName(), "Create " + DATABASE_NAME);
        sdb.execSQL("CREATE TABLE users (id VARCHAR PRIMARY KEY NOT NULL, username VARCHAR, password VARCHAR, topic VARCHAR)");
        sdb.execSQL("CREATE TABLE news_like (news_id VARCHAR, user_id VARCHAR)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldV, int newV) {
        Log.i(DatabaseHelper.class.getSimpleName(), String.format("Upgrade oldV:%d to newV:%d", oldV, newV));
    }

    // login and signup
    public boolean login(String uname, String pword) {
        SQLiteDatabase sdb = dh.getWritableDatabase();
        Cursor lc = sdb.rawQuery("select * from users where username = ? and password = ? ", new String[]{uname, pword});
        return lc.getCount() > 0;
    }
    public void signup(String uname, String pword) {
        SQLiteDatabase sdb = dh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", UUID.randomUUID().toString());
        cv.put("username", uname);
        cv.put("password", pword);
        sdb.insert("users", null, cv);
    }

    // getUser and updateUserTopic
    public UserModel getUser(String uname) {
        SQLiteDatabase sdb = dh.getWritableDatabase();
        Cursor guc = sdb.rawQuery("select * from users where username = ? ", new String[]{uname});
        if (null != guc && guc.moveToNext()) {
            String i = guc.getString(guc.getColumnIndex("id"));
            String n = guc.getString(guc.getColumnIndex("username"));
            String p = guc.getString(guc.getColumnIndex("password"));
            String t = guc.getString(guc.getColumnIndex("topic"));
            UserModel u = new UserModel();
            u.setId(i);
            u.setUsername(n);
            u.setPassword(p);
            u.setUserTopic(t);
            return u;
        }
        return null;
    }
    public boolean setUserTopic(String uId, String uTopic) {
        SQLiteDatabase sdb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", uId);
        cv.put("topic", uTopic);
        long ur = sdb.update("users", cv, "id=?", new String[]{uId});
        return ur > 0;
    }

    // getNewsList
    public List<NewsModel> getNewsList(String uId, List<String> topicList) {
        List<NewsModel> newsList = new ArrayList<>();
        for (String topic : News.newsPackMap.keySet()) {
            if ( topicList==null || topicList.contains(topic)) {
                newsList.addAll(News.newsPackMap.get(topic));
            }
        }

        // like id map
        List<String> lIdsList = new ArrayList<>();
        SQLiteDatabase sdb = this.getWritableDatabase();
        Cursor lc = sdb.rawQuery("select * from news_like where user_id = ? ", new String[]{uId});
        while (null != lc && lc.moveToNext()) {
            String lId = lc.getString(lc.getColumnIndex("news_id"));
            lIdsList.add(lId);
        }
        for (NewsModel nm : newsList) {
            nm.setLike(lIdsList.contains(nm.getId()));
        }
        return newsList;
    }

    // likeNews, dislikeNews and likeList
    public void likeNews(String nId, String uId) {
        SQLiteDatabase sdb = dh.getWritableDatabase();
        sdb.execSQL("insert into news_like(news_id, user_id) values (?, ?)", new Object[]{nId, uId});
        sdb.close();
    }
    public void dislikeNews(String nId, String uId) {
        SQLiteDatabase sdb = dh.getWritableDatabase();
        sdb.execSQL("delete from news_like where news_id = ? and user_id = ? ", new Object[]{nId, uId});
        sdb.close();
    }
    public List<NewsModel> likeList(String uId) {
        List<NewsModel> nList = getNewsList(uId, null);
        List<NewsModel> lList = new ArrayList<>();
        for (NewsModel n : nList) {
            if (n.isLike()) {
                lList.add(n);
            }
        }
        return lList;
    }

    // searchList
    public List<NewsModel> searchList(String uId, String kw, List<String> tList) {
        List<NewsModel> nList = getNewsList(uId, tList);
        List<NewsModel> sList = new ArrayList<>();
        boolean e = null == kw || kw.trim().length() == 0;
        for (NewsModel n : nList) {
            if (e) {
                sList.add(n);
            } else {
                String k = kw.trim().toLowerCase();
                if (n.getTitle().toLowerCase().contains(k) || n.getNewsTopic().toLowerCase().contains(k)) {
                    sList.add(n);
                }
            }
        }
        return sList;
    }
}
