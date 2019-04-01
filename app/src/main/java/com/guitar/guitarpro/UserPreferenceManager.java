package com.guitar.guitarpro;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferenceManager {

    private SharedPreferences pref;
    SharedPreferences.Editor editor;
    UserPreferenceManager(Context context) {
        pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        pref.getBoolean("onboarding_complete", false);
        pref.getString("last_screen", null);
    }

    public void setOnboardingComplete(String key, boolean value) {
        editor = pref.edit();

        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getOnboardingComplete(String key) {
        return pref.getBoolean(key, false);
    }

    public void setLastScreen(String key, String value) {
        editor = pref.edit();

        editor.putString(key, value);
        editor.apply();
    }

    public String getLastScreen(String key) {
        return pref.getString(key, null);
    }
}