package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static String lastScreen = "last_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        UserPreferenceManager pref = UserPreferenceManager.getInstance(this);

        if (pref.getLastScreen(lastScreen) == null) {
            loadFragment(new SettingFragment());

            navigation.setSelectedItemId(R.id.settings);

            Intent intent = new Intent(this,
                    OnboardingActivity.class);
            startActivity(intent);
        } else {
            int id = 0;
            switch (pref.getLastScreen(lastScreen)) {
                case UserPreferenceManager.chords:
                    id = R.id.chords;
                    break;
                case UserPreferenceManager.scales:
                    id = R.id.scale;
                    break;
                case UserPreferenceManager.songs:
                    id = R.id.songs;
                    break;
                case UserPreferenceManager.settings:
                    id = R.id.settings;
                    break;
            }
            navigation.setSelectedItemId(id);
//        String lastScreen = pref.getLastScreen("last_screen");
//        switch (lastScreen) {
//            case "chords":
//                loadFragment(new ChordFragment());
//                break;
//            case "scales":
//                loadFragment(new ScaleFragment());
//                break;
//            case "songs":
//                loadFragment(new SongFragment());
//                break;
//            case "settings":
//                loadFragment(new SettingFragment());
//                break;
//        }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        UserPreferenceManager pref = UserPreferenceManager.getInstance(this);

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
