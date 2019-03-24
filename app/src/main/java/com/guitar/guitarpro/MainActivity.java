package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void openConnectionActivity(View view) {
        Intent intent = new Intent(this,
                ConnectionActivity.class);
        startActivity(intent);
    }
}
