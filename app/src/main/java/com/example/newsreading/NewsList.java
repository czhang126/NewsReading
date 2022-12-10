package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.ListView;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NewsList extends AppCompatActivity {

    // NewsList Elements: nlNewsAdapter, nlNewsList
    private NewsAdapter nlNewsAdapter;
    private List<NewsModel> nlNewsList = new ArrayList<>();

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        // Home Bar creation and configuration
        ActionBar nlhBar = getSupportActionBar();
        if (null != nlhBar) {
            nlhBar.hide();
        }
        findViewById(R.id.imageHomeBarLike).setOnClickListener(v -> startActivity(new Intent(this, LikeList.class)));
        findViewById(R.id.imageHomeBarSearch).setOnClickListener(v -> startActivity(new Intent(this, Search.class)));

        // News List creation and configuration
        ListView lnl = findViewById(R.id.listNews);
        nlNewsAdapter = new NewsAdapter(this, R.layout.activity_item_news, nlNewsList);
        lnl.setAdapter(nlNewsAdapter);
        lnl.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent inlnd = new Intent(getApplicationContext(), NewsDetail.class);
            inlnd.putExtra("news", nlNewsList.get(i));
            startActivity(inlnd);
        });
        refreshNewsList();

        // Refresh news list according to the action
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
                refreshNewsList();
            }
        }, new IntentFilter(App.REFRESH_NEWS));
    }

    // refreshNewsList
    private void refreshNewsList() {
        UserModel nlu = App.nowUser;
        String uId = nlu.getId();
        List<String> tl = Arrays.asList(nlu.getUserTopic().split(","));
        DatabaseHelper dh = DatabaseHelper.getDh();
        List<NewsModel> nln = dh.getNewsList(uId, tl);
        nlNewsList.clear();
        nlNewsList.addAll(nln);
        nlNewsAdapter.notifyDataSetChanged();
    }
}