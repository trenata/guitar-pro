package com.guitar.guitarpro;

import android.os.Bundle;

import com.guitar.guitarpro.connectivity.MockGuitarConnectionManager;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
    }
}
