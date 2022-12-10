package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ListView;
import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {

    // Search Elements: sNewsAdapter, sNewsList, sKeywords
    private NewsAdapter sNewsAdapter;
    private List<NewsModel> sNewsList = new ArrayList<>();
    private String sKeywords = null;

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_search);

        // Search Bar creation and configuration
        ActionBar ssBar = getSupportActionBar();
        if (null != ssBar) {
            ssBar.hide();
        }
        ImageView isHome = findViewById(R.id.imageSearchBarHome);
        isHome.setOnClickListener(v -> this.finish());
        EditText etsBar = findViewById(R.id.editTextSearchBar);
        etsBar.setVisibility(View.VISIBLE);
        findViewById(R.id.textSearchBarTitle).setVisibility(View.GONE);
        findViewById(R.id.imageSearchBarIcon).setOnClickListener(v -> {
            sKeywords = etsBar.getText().toString();
            refreshSearch();
        });

        // Search action details
        ListView ls = findViewById(R.id.listSearch);
        sNewsAdapter = new NewsAdapter(this, R.layout.activity_item_news, sNewsList);
        ls.setAdapter(sNewsAdapter);
        ls.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent isnd = new Intent(getApplicationContext(), NewsDetail.class);
            isnd.putExtra("news", sNewsList.get(i));
            startActivity(isnd);
        });
        refreshSearch();

        // Refresh search list according to the action
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(Search.class.getSimpleName(), "REFRESH_NEWS");
                refreshSearch();
            }
        }, new IntentFilter(App.REFRESH_NEWS));
    }

    // refreshSearch
    private void refreshSearch() {
        sNewsAdapter.setNewsAdapterKeywords(sKeywords);
        UserModel sUser = App.nowUser;
        String uId = sUser.getId();
        List<String> lt = Arrays.asList(sUser.getUserTopic().split(","));
        DatabaseHelper dh = DatabaseHelper.getDh();
        List<NewsModel> sl = dh.searchList(uId, sKeywords, lt);
        sNewsList.clear();
        sNewsList.addAll(sl);
        if (sl.isEmpty()) {
            findViewById(R.id.listSearch).setVisibility(View.GONE);
        } else {
            findViewById(R.id.listSearch).setVisibility(View.VISIBLE);
            sNewsAdapter.notifyDataSetChanged();
        }
    }
}