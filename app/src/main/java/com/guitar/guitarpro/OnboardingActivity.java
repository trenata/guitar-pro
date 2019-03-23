package com.guitar.guitarpro;

import android.os.Bundle;

import com.rd.PageIndicatorView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        final PageIndicatorView pageIndicatorView = findViewById(R.id.page_indicator_view);
        pageIndicatorView.setViewPager(viewPager);
    }
}


