package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.guitar.guitarpro.connectivity.GuitarConnectionManager;
import com.guitar.guitarpro.connectivity.RealGuitarConnectionManager;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.connection_activity);
    }

    public void pair(View view) {
        RealGuitarConnectionManager.getInstance().connect(new GuitarConnectionManager.ConnectionCallback() {
            @Override
            public void onConnected() {
                Toast.makeText(ConnectionActivity.this, "Connected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onConnectionError() {
                Toast.makeText(ConnectionActivity.this, "Connection error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
