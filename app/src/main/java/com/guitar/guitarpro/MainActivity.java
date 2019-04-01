package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        UserPreferenceManager preferences = new UserPreferenceManager(this);

        if (!preferences.getOnboardingComplete("onboarding_complete")) {
            Intent intent = new Intent(this, OnboardingActivity.class);
            startActivity(intent);
        }

        if (savedInstanceState == null) {
            loadFragment(new SettingsFragment());
        } else {
            Fragment fragment = null;
            switch (preferences.getLastScreen("last_screen")) {
                case "chords":
                    fragment = new ChordsFragment();
                    break;
                case "scales":
                    fragment = new ScalesFragment();
                    break;
                case "songs":
                    fragment = new SongsFragment();
                    break;
                case "settings":
                    fragment = new SettingsFragment();
                    break;
            }
            loadFragment(fragment);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        UserPreferenceManager preferences = new UserPreferenceManager(this);

        switch (item.getItemId()) {
            case R.id.chords:
                fragment = new ChordsFragment();
                preferences.setLastScreen("last_screen", "chords");

                break;

            case R.id.scales:
                fragment = new ScalesFragment();
                preferences.setLastScreen("last_screen", "scales");

                break;

            case R.id.songs:
                fragment = new SongsFragment();
                preferences.setLastScreen("last_screen", "songs");

                break;

            case R.id.settings:
                fragment = new SettingsFragment();
                preferences.setLastScreen("last_screen", "settings");

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
        Intent intent = new Intent(this, ConnectionActivity.class);

        startActivity(intent);
    }
}
