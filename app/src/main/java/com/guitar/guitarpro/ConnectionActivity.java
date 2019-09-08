package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.guitar.guitarpro.connectivity.GuitarConnectionManager;
import com.guitar.guitarpro.connectivity.MockGuitarConnectionManager;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MockGuitarConnectionManager.getInstance().isConnected()) {
            setContentView(R.layout.connection_activity);
        } else {
            setContentView(R.layout.disconnected_activity);
        }
    }

    public void pair(View view) {
        MockGuitarConnectionManager.getInstance().connect(new GuitarConnectionManager.ConnectionCallback() {
            @Override
            public void onConnected() {
                Toast.makeText(ConnectionActivity.this, "Connected", Toast.LENGTH_LONG).show();
                setContentView(R.layout.disconnected_activity);
            }

            @Override
            public void onConnectionError() {
                Toast.makeText(ConnectionActivity.this, "Connection error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void unPair(View view) {

        Toast.makeText(ConnectionActivity.this, "Disconnected", Toast.LENGTH_LONG).show();
        setContentView(R.layout.connection_activity);
        MockGuitarConnectionManager.getInstance().disconnect();
    }

    public void closeConnectionActivity(View view) {
        finish();
    }
}
