package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChordsFragment extends Fragment {

    ChordsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CheckedTextView checkedTextView = getView().findViewById(R.id.chordC);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // do sthg
            }
        });

        return inflater.inflate(R.layout.chords_fragment, null);
    }
}

