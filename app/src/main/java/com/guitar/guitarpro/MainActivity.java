package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.guitar.guitarpro.connectivity.MockGuitarConnectionManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private UserPreferenceManager preferences;
    private static String lastScreen = "last_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setActionBar(myToolbar);


        preferences = UserPreferenceManager.getInstance(this);

        if (preferences.getLastScreen(lastScreen) == null) {
            loadFragment(new MoreFragment());
            navigation.setSelectedItemId(R.id.settings);

            startActivity(new Intent(this, OnboardingActivity.class));
        } else {
            int id = 0;

            switch (preferences.getLastScreen(lastScreen)) {
                case UserPreferenceManager.chords:
                    id = R.id.chords;

                    break;

                case UserPreferenceManager.scales:
                    id = R.id.scales;

                    break;

                case UserPreferenceManager.songs:
                    id = R.id.songs;

                    break;

                case UserPreferenceManager.settings:
                    id = R.id.settings;

                    break;
            }

            navigation.setSelectedItemId(id);
        }

        ImageView bluestoothIcon = findViewById(R.id.bluetooth_icon);

        if (MockGuitarConnectionManager.getInstance().isConnected()) {
            bluestoothIcon.setImageResource(R.drawable.ic_bluetooth_connected_blue_24dp);
        } else {
            bluestoothIcon.setImageResource(R.drawable.ic_bluetooth_black_24dp);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.chords:
                fragment = new ChordsFragment();
                preferences.setLastScreen(lastScreen, UserPreferenceManager.chords);

                break;

            case R.id.scales:
                fragment = new ScalesFragment();
                preferences.setLastScreen(lastScreen, UserPreferenceManager.scales);

                break;

            case R.id.songs:
                fragment = new SongsFragment();
                preferences.setLastScreen(lastScreen, UserPreferenceManager.songs);

                break;

            case R.id.settings:
                fragment = new MoreFragment();
                preferences.setLastScreen(lastScreen, UserPreferenceManager.settings);

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
