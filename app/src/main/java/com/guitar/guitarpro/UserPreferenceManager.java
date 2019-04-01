package com.guitar.guitarpro;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferenceManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefsEditor;

    public UserPreferenceManager(Context context) {

        sharedPreferences = context.getSharedPreferences("My preferences", MODE_PRIVATE);
        sharedPreferences.getBoolean("onboarding_complete", false);
        sharedPreferences.getString("last_screen", "settings");

    }


    public void setShouldShowOnboarding(String key, Boolean value) {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public Boolean getShouldShowOnboarding(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void setLastScreen(String key, String value) {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public String getLastScreen(String key) {
        return sharedPreferences.getString(key,"settings");
    }
}
