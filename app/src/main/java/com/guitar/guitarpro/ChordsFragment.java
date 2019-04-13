package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChordsFragment extends Fragment {

    ChordsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chords_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final CheckedTextView chordC = view.findViewById(R.id.chordC);
        chordC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordC);
            }
        });

        final CheckedTextView chordD = view.findViewById(R.id.chordD);
        chordD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordD);
            }
        });

        final CheckedTextView chordE = view.findViewById(R.id.chordE);
        chordE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordE);
            }
        });

        final CheckedTextView chordF = view.findViewById(R.id.chordF);
        chordF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordF);
            }
        });

        final CheckedTextView chordG = view.findViewById(R.id.chordG);
        chordG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordG);
            }
        });

        final CheckedTextView chordH = view.findViewById(R.id.chordH);
        chordH.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordH);
            }
        });

        final CheckedTextView chordA = view.findViewById(R.id.chordA);
        chordA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectOne(chordA);
            }
        });
    }

    private void selectOne(CheckedTextView chord) {
        CheckedTextView[] chords = {getView().findViewById(R.id.chordC),
                getView().findViewById(R.id.chordD),
                getView().findViewById(R.id.chordE),
                getView().findViewById(R.id.chordF),
                getView().findViewById(R.id.chordG),
                getView().findViewById(R.id.chordH),
                getView().findViewById(R.id.chordA)
        };

        for (int i = 0; i < chords.length; i++) {
            if (chord != chords[i]) {
                chords[i].setChecked(false);
            }
            chord.toggle();
        }
    }
}

