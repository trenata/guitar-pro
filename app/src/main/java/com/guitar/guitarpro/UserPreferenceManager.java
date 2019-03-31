package com.guitar.guitarpro;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferenceManager {

    private SharedPreferences pref;

    UserPreferenceManager(Context context) {
        pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        pref.getBoolean("onboarding_complete", false);

        editor.apply();
    }

    public void setOnboardingComplete(String key, boolean value) {
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getOnboardingComplete(String key) {
        return pref.getBoolean(key, false);
    }
}