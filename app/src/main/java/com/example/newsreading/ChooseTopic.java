package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import java.util.List;
import java.util.ArrayList;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseTopic extends AppCompatActivity {

    // ChooseTopic Element: ctIds
    private int[] ctIds = new int[]{R.id.textChooseArt, R.id.textChooseSport, R.id.textChooseScience, R.id.textChooseBusiness, R.id.textChooseTechnology};

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_topic);

        // Search Bar creation and configuration
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Choose topic
        for (int id : ctIds) {
            findViewById(id).setOnClickListener(view -> {
                TextView tv = (TextView) view;
                Object tag = view.getTag();
                if ("1".equals(tag)) {
                    view.setTag("2");
                    tv.setBackgroundResource(R.drawable.selector_topic_item_select);
                } else {
                    view.setTag("1");
                    tv.setBackgroundResource(R.drawable.selector_topic_item);
                }
            });
        }
        findViewById(R.id.buttonChooseTopic).setOnClickListener(v -> executeChoose());
    }

    // executeChoose
    private void executeChoose() {
        List<String> sl = new ArrayList<>();
        for (int id : ctIds) {
            TextView tv = findViewById(id);
            if ("2".equals(tv.getTag())) {
                sl.add(tv.getText().toString());
            }
        }
        String ts = String.join(",", sl);
        App.nowUser.setUserTopic(ts);
        DatabaseHelper.getDh().setUserTopic(App.nowUser.getId(), ts);
        Intent ictnl = new Intent(getApplicationContext(), NewsList.class);
        startActivity(ictnl);
        ChooseTopic.this.finish();
    }
}
