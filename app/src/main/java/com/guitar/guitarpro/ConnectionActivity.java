package com.guitar.guitarpro;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.connection_activity);
    }

    public void showSnackBar(View view){
        Snackbar.make(findViewById(R.id.connection), R.string.error,
                Snackbar.LENGTH_LONG)
                .show();
    }
}
