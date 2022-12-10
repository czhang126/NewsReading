package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NewsDetail extends AppCompatActivity {

    // NewsDetail Element: imageLike
    ImageView ndImageLike;

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_detail);

        // Search Bar creation and configuration
        ActionBar ndsBar = getSupportActionBar();
        if (null != ndsBar) {
            ndsBar.hide();
        }
        ImageView isbHome = findViewById(R.id.imageSearchBarHome);
        isbHome.setImageResource(R.drawable.icon_home);
        isbHome.setOnClickListener(v -> this.finish());
        findViewById(R.id.textSearchBarTitle).setVisibility(View.GONE);
        findViewById(R.id.editTextSearchBar).setVisibility(View.GONE);
        findViewById(R.id.imageSearchBarIcon).setVisibility(View.GONE);
        NewsModel n = (NewsModel) getIntent().getSerializableExtra("news");

        // News details creation and configuration
        TextView ndTitle = findViewById(R.id.textDetailNewsTitle);
        ndTitle.setText(n.getTitle());
        TextView ndTopic = findViewById(R.id.textDetailNewsTopic);
        ndTopic.setText((n.getNewsTopic()));
        ImageView ndImage = findViewById(R.id.imageDetailNews);
        ndImage.setImageResource(n.getImageById());
        TextView ndContent = findViewById(R.id.textDetailNewsContent);
        ndContent.setText(n.getContent());
        ndImageLike = findViewById(R.id.imageDetailNewsLike);
        ndImageLike.setImageResource(n.isLike() ? R.drawable.icon_like_red : R.drawable.icon_like_black_border);
        ndImageLike.setOnClickListener(v -> {
            n.setLike(!n.isLike());
            newsDetailLike(n.getId(), n.isLike());
            ndImageLike.setImageResource(n.isLike() ? R.drawable.icon_like_red : R.drawable.icon_like_black_border);
        });
    }

    // newsDetailLike
    private void newsDetailLike(String nId, boolean l) {
        String uId = App.nowUser.getId();
        DatabaseHelper dh = DatabaseHelper.getDh();
        if (l) {
            dh.likeNews(nId, uId);
        } else {
            dh.dislikeNews(nId, uId);
        }
    }
}
