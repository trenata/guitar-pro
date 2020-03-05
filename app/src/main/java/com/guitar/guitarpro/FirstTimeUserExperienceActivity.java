package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.View;

import com.rd.PageIndicatorView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class FirstTimeUserExperienceActivity extends AppCompatActivity {
    private static String lastScreen = "last_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_time_user_expreience_activity);

        ViewPager viewPager = findViewById(R.id.view_pager_first);
        viewPager.setAdapter(new FirstPagerAdapter(this));

        final PageIndicatorView pageIndicatorView = findViewById(R.id.page_indicator_view_first);
        pageIndicatorView.setViewPager(viewPager);

    }

    public void closeFirst(View view) {
        UserPreferenceManager preferences = UserPreferenceManager.getInstance(this);
        preferences.setLastScreen(lastScreen, UserPreferenceManager.settings);

        finish();
    }
}
