package com.guitar.guitarpro;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.google.android.material.snackbar.Snackbar;
import com.guitar.guitarpro.model.Chord;
import com.guitar.guitarpro.model.Color;
import com.guitar.guitarpro.model.Note;
import com.guitar.guitarpro.model.SelectableChord;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChordsFragment extends Fragment implements ChordsAdapter.OnItemSelectedListener {

    private RecyclerView mRecyclerView;
    private String[] mChordList;

    RecyclerView recyclerView;
    ChordsAdapter adapter;

    public ChordsFragment() {

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
            chord.setChecked(true);
        }
        setAdapter(chord);
    }

    private void setAdapter(CheckedTextView chosenChord) {
//        if (chosenChord == getView().findViewById(R.id.chordC)) {
//            mChordList = new String[]{"C", "Cm"};
//        } else if (chosenChord == getView().findViewById(R.id.chordD)) {
//            mChordList = new String[]{"D", "Dm"};
//        } else if (chosenChord == getView().findViewById(R.id.chordE)) {
//            mChordList = new String[]{"E", "Em"};
//        } else if (chosenChord == getView().findViewById(R.id.chordF)) {
//            mChordList = new String[]{"F", "Fm"};
//        } else if (chosenChord == getView().findViewById(R.id.chordG)) {
//            mChordList = new String[]{"G", "Gm"};
//        } else if (chosenChord == getView().findViewById(R.id.chordH)) {
//            mChordList = new String[]{"H", "Hm"};
//        } else if (chosenChord == getView().findViewById(R.id.chordA)) {
//            mChordList = new String[]{"A", "Am"};
//        } else {
//            mChordList = new String[]{""};
//        }
        mRecyclerView = getView().findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        List<SelectableChord> selectableItems = generateItems(chosenChord);

        adapter = new ChordsAdapter(this);
        mRecyclerView.setAdapter(adapter);


        List<SelectableChord> selectedChords = new ArrayList<>();
        //todo
        adapter.setChords(selectedChords);
    }

    public List<SelectableChord> generateItems(CheckedTextView chosenChord) {

        List<SelectableChord> selectableItems = new ArrayList<>();

        if (chosenChord == getView().findViewById(R.id.chordC)) {
            selectableItems.add(new SelectableChord(new Chord.Builder().addNote(
                    new Note(5, 1, Color.RED)).
                    addNote(new Note(3, 2, Color.GREEN)).
                    addNote(new Note(2, 3, Color.BLUE)).
                    addNote(new Note(1, 0, Color.WHITE)).
                    addNote(new Note(4, 0, Color.WHITE)).
                    addNote(new Note(6, 0, Color.WHITE)).build(), false));
            selectableItems.add(new SelectableChord("Cm", false));
        } else if (chosenChord == getView().findViewById(R.id.chordD)) {
            selectableItems.add(new SelectableChord("D", false));
            selectableItems.add(new SelectableChord("Dm", false));
        } else if (chosenChord == getView().findViewById(R.id.chordE)) {
            selectableItems.add(new SelectableChord("E", false));
            selectableItems.add(new SelectableChord("Em", false));
        } else if (chosenChord == getView().findViewById(R.id.chordF)) {
            selectableItems.add(new SelectableChord("F", false));
            selectableItems.add(new SelectableChord("Fm", false));
        } else if (chosenChord == getView().findViewById(R.id.chordG)) {
            selectableItems.add(new SelectableChord("G", false));
            selectableItems.add(new SelectableChord("Gm", false));
        } else if (chosenChord == getView().findViewById(R.id.chordH)) {
            selectableItems.add(new SelectableChord("H", false));
            selectableItems.add(new SelectableChord("Hm", false));
        } else if (chosenChord == getView().findViewById(R.id.chordA)) {
            selectableItems.add(new SelectableChord("A", false));
            selectableItems.add(new SelectableChord("Am", false));
        } else {
            selectableItems.add(new SelectableChord("", false));
        }
        return selectableItems;
    }


    @Override
    public void onItemSelected(SelectableChord selectableChord) {

        List<SelectableChord> selectedItems = adapter.getSelectedChords();
        Snackbar.make(recyclerView, "Selected item is " + selectableChord.getChord() +
                ", Totally  selectem item count is " + selectedItems.size(), Snackbar.LENGTH_LONG).show();
    }

}

