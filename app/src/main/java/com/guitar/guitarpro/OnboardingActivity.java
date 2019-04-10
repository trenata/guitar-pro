package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.View;

import com.rd.PageIndicatorView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnboardingActivity extends AppCompatActivity {
    private static String lastScreen = "last_screen";

    private static String lastScreen = "last_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        final PageIndicatorView pageIndicatorView = findViewById(R.id.page_indicator_view);
        pageIndicatorView.setViewPager(viewPager);

    }

    public void closeOnboarding(View view) {
        UserPreferenceManager preferences = UserPreferenceManager.getInstance(this);
        preferences.setLastScreen(lastScreen, UserPreferenceManager.settings);

        finish();
    }
}


