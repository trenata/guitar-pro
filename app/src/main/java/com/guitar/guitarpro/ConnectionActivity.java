package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.guitar.guitarpro.connectivity.GuitarConnectionManager;
import com.guitar.guitarpro.connectivity.MockGuitarConnectionManager;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {

    MockGuitarConnectionManager mockGuitarConnectionManager = new MockGuitarConnectionManager();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.connection_activity);

//        MockGuitarConnectionManager mockGuitarConnectionManager = new MockGuitarConnectionManager();
//
//        if( !mockGuitarConnectionManager.isConnected())
//        {
//            Snackbar.make(findViewById(R.id.connection), R.string.error,
//                    Snackbar.LENGTH_LONG)
//                    .show();
//        }

    }

    public void showSnackBar(View view) {
//        GuitarConnectionManager.ConnectionCallback connectionCallback = null;
//        mockGuitarConnectionManager.connect(connectionCallback);
        Snackbar.make(findViewById(R.id.connection), R.string.error,
                Snackbar.LENGTH_LONG)
                .show();
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
