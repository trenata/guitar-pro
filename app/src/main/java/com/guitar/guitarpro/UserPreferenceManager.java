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
        sharedPreferences.getInt("last_screen",0);

    }


    public void setShouldShowOnboarding(String key, Boolean value) {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public Boolean getShouldShowOnboarding(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void setLastScreen(String key, int value){
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key,value);
        prefsEditor.apply();
    }
    public int getLastScreen(String key){
        return sharedPreferences.getInt(key,0);
    }
}
