package com.guitar.guitarpro.connectivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import com.guitar.guitarpro.model.Chord;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class RealGuitarConnectionManager implements GuitarConnectionManager {

    private static final String DEVICE_ID = "00:18:E4:34:BE:5D";
    private static RealGuitarConnectionManager INSTANCE;
    private BluetoothSocket bluetoothSocket;

    private RealGuitarConnectionManager() {
        // Avoids direct instantiation
    }

    public static RealGuitarConnectionManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RealGuitarConnectionManager();
        }
        return INSTANCE;
    }

    @Override
    public boolean isConnected() {
        return bluetoothSocket.isConnected();
    }

    @Override
    public void connect(ConnectionCallback connectionCallback) {
        try {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter != null) {
                bluetoothAdapter.enable();
                bluetoothSocket = bluetoothAdapter.getRemoteDevice(DEVICE_ID).createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                bluetoothAdapter.cancelDiscovery();
                if (bluetoothSocket != null) {
                    bluetoothSocket.connect();
                }
            }
        } catch (Exception exception) {
            Log.e("RealConnectionManager", exception.getMessage(), exception);
        } finally {
            if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
                connectionCallback.onConnected();
            } else {
                connectionCallback.onConnectionError();
            }
        }
    }

    @Override
    public void disconnect() {
        try {
            bluetoothSocket.close();
        } catch (IOException e) {
            Log.e("RealConnectionManager", "Couldn't disconnect: " + e.getMessage(), e);
        }
    }

    @Override
    public void sendChord(Chord chord) {
        if (isConnected() && bluetoothSocket != null) {
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                outputStream.write(chord.getEncodedNotes().getBytes());
            } catch (IOException exception) {
                Log.e("RealConnectionManager", exception.getMessage(), exception);
                exception.printStackTrace();
            }
        } else {
            Log.e("RealConnectionManager", "Couldn't send the chord. Not connected");
        }
    }
}
