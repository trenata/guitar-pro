package com.guitar.guitarpro;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferenceManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private static UserPreferenceManager INSTANCE;

    private static String lastScreen = "last_screen";

    public static final String chords = "chords";
    public static final String scales = "scales";
    public static final String songs = "songs";
    public static final String settings = "settings";

    private UserPreferenceManager(Context context) {
        pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        pref.getString(lastScreen, null);
    }

    public void setLastScreen(String key, String value) {
        editor = pref.edit();

        editor.putString(key, value);
        editor.apply();
    }

    public String getLastScreen(String key) {
        return pref.getString(key, null);
    }

    public static UserPreferenceManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UserPreferenceManager(context);
        }
        return INSTANCE;
    }
}