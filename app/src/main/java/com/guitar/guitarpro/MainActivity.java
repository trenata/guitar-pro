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

        UserPreferenceManager pref = new UserPreferenceManager(this);

        if (!pref.getShouldShowOnboarding("onboarding_complete")) {
            Intent intent = new Intent(this,
                    OnboardingActivity.class);
            startActivity(intent);
        }

        String lastScreen = pref.getLastScreen("last_screen");
        switch (lastScreen) {
            case "chords":
                loadFragment(new ChordFragment());
                break;
            case "scales":
                loadFragment(new ScaleFragment());
                break;
            case "songs":
                loadFragment(new SongFragment());
                break;
            case "settings":
                loadFragment(new SettingFragment());
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        UserPreferenceManager pref = new UserPreferenceManager(this);

        switch (item.getItemId()) {
            case R.id.chords: {
                pref.setLastScreen("last_screen", "chords");
                fragment = new ChordFragment();
                break;
            }
            case R.id.scale: {
                pref.setLastScreen("last_screen", "scales");
                fragment = new ScaleFragment();

                break;
            }
            case R.id.songs: {
                pref.setLastScreen("last_screen", "songs");
                fragment = new SongFragment();

                break;
            }
            case R.id.settings: {
                pref.setLastScreen("last_screen", "settings");
                fragment = new SettingFragment();
                break;
            }
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
