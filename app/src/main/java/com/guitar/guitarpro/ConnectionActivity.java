package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.guitar.guitarpro.connectivity.GuitarConnectionManager;
import com.guitar.guitarpro.connectivity.MockGuitarConnectionManager;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.connection_activity);
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
