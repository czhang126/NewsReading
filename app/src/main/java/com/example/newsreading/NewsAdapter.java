package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import java.util.List;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Intent;
import android.content.Context;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewsAdapter extends ArrayAdapter<NewsModel> {

    // NewsAdapter Elements: naContext
    private Context naContext;
    private String naKeywords;

    // Constructor
    public NewsAdapter(@NonNull Context c, int res, @NonNull List<NewsModel> nl) {
        super(c, res, nl);
        naContext = c;
    }

    // getView and refreshNews
    @NonNull
    @Override
    public View getView(int p, @Nullable View cView, @NonNull ViewGroup vGroup) {
        NewsModel n = getItem(p);
        String nId = n.getId();
        View vItemNews = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_news, vGroup, false);
        ImageView iin = vItemNews.findViewById(R.id.imageItemNews);
        TextView tinTitle = vItemNews.findViewById(R.id.textItemNewsTitle);
        TextView tinTopic = vItemNews.findViewById(R.id.textItemNewsTopic);
        iin.setImageResource(n.getImageById());
        tinTitle.setText(n.getTitle());
        tinTopic.setText(n.getNewsTopic());
        ImageView iinl = vItemNews.findViewById(R.id.imageItemNewsLike);
        iinl.setImageResource(n.isLike() ? R.drawable.icon_like_red : R.drawable.icon_like_black_border);
        iinl.setOnClickListener((v -> onClickLike(nId, !n.isLike())));
        return vItemNews;
    }
    private void refreshNews() {
        Intent i = new Intent();
        i.setAction(App.REFRESH_NEWS);
        naContext.sendBroadcast(i);
    }

    // onClickLike
    public void onClickLike(String nId, boolean l) {
        Log.i(NewsAdapter.class.getSimpleName(), String.format("onClickLike:%s %s", nId, l ? "true" : "false"));
        String uId = App.nowUser.getId();
        DatabaseHelper dh = DatabaseHelper.getDh();
        if (l) {
            dh.likeNews(nId, uId);
        } else {
            dh.dislikeNews(nId, uId);
        }
        refreshNews();
    }

    // setNewsAdapterKeywords
    public void setNewsAdapterKeywords(String nak) {
        this.naKeywords = nak;
    }
}
