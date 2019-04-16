package com.guitar.guitarpro.connectivity;

import com.guitar.guitarpro.model.Chord;

public interface GuitarConnectionManager {

    interface ConnectionCallback {

        void onConnected();

        void onConnectionError();
    }

    boolean isConnected();

    void connect(ConnectionCallback connectionCallback);

    void disconnect();

    void sendChord(Chord chord);
}
