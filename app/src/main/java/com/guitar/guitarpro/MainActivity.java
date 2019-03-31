package com.guitar.guitarpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        if (savedInstanceState == null) {
            loadFragment(new ChordFragment());
        } else {
            finish();
        }

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        UserPreferenceManager preferences = new UserPreferenceManager(this);

        if(!preferences.getShouldShowOnboarding("onboarding_complete")){
            Intent intent = new Intent(this,
                    OnboardingActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.chords:
                fragment = new ChordFragment();
                break;

            case R.id.scale:
                fragment = new ScaleFragment();
                break;
            case R.id.songs:
                fragment = new SongFragment();
                break;
            case R.id.settings:
                fragment = new SettingFragment();
                break;


        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    public void openConnectionActivity(View view) {
        Intent intent = new Intent(this,
                ConnectionActivity.class);
        startActivity(intent);
    }
}
