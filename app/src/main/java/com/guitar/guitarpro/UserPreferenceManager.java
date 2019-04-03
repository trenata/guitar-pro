package com.guitar.guitarpro;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferenceManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefsEditor;
    private static UserPreferenceManager INSTANCE = null;
    private static String lastScreen = "last_screen";
    public static final String chords = "chords";
    public static final String scales = "scales";
    public static final String songs = "songs";
    public static final String settings = "settings";

    static UserPreferenceManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UserPreferenceManager(context);
        }
        return INSTANCE;
    }

    private UserPreferenceManager(Context context) {

        sharedPreferences = context.getSharedPreferences("My preferences", MODE_PRIVATE);
        sharedPreferences.getString(lastScreen, null);
    }

    public void setLastScreen(String key, String value) {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public String getLastScreen(String key) {
        return sharedPreferences.getString(key, null);
    }
}
