package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import java.util.List;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LikeList extends AppCompatActivity {

    // LikeList Elements: liNewsAdapter, liNewsList
    private NewsAdapter liNewsAdapter;
    private List<NewsModel> liNewsList = new ArrayList<>();

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_like);

        // Search Bar creation and configuration
        ActionBar llsBar = getSupportActionBar();
        if (null != llsBar) {
            llsBar.hide();
        }
        ImageView isbHome = findViewById(R.id.imageSearchBarHome);
        isbHome.setImageResource(R.drawable.icon_home);
        isbHome.setOnClickListener(v -> this.finish());
        TextView tsbTitle = findViewById(R.id.textSearchBarTitle);
        tsbTitle.setText("Like");
        findViewById(R.id.imageSearchBarIcon).setVisibility(View.GONE);

        // Like List creation and configuration
        ListView lll = findViewById(R.id.listLike);
        liNewsAdapter = new NewsAdapter(this, R.layout.activity_item_news, liNewsList);
        lll.setAdapter(liNewsAdapter);
        lll.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent illnd = new Intent(getApplicationContext(), NewsDetail.class);
            illnd.putExtra("news", liNewsList.get(i));
            startActivity(illnd);
        });
        refreshLikeList();

        // Refresh like list according to the action
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                refreshLikeList();
            }
        }, new IntentFilter(App.REFRESH_NEWS));
    }

    // refreshLikeList
    private void refreshLikeList() {
        DatabaseHelper dh = DatabaseHelper.getDh();
        List<NewsModel> lin = dh.likeList(App.nowUser.getId());
        liNewsList.clear();
        liNewsList.addAll(lin);
        if (lin.isEmpty()) {
            findViewById(R.id.listLike).setVisibility(View.GONE);
            findViewById(R.id.listLike).setVisibility(View.VISIBLE);
            liNewsAdapter.notifyDataSetChanged();
        }
    }
}

