package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.guitar.guitarpro.connectivity.RealGuitarConnectionManager;
import com.guitar.guitarpro.model.Chord;
import com.guitar.guitarpro.model.Color;
import com.guitar.guitarpro.model.Key;
import com.guitar.guitarpro.model.Note;
import com.guitar.guitarpro.model.SelectableChord;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChordsFragment extends Fragment implements ChordsAdapter.OnItemSelectedListener {

    private ChordsAdapter adapter;
    private List<CheckedTextView> chords = new ArrayList<>();
    private Key selectedKey;

    public ChordsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chords_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setupChord(R.id.chordC, Key.C);
        setupChord(R.id.chordD, Key.D);
        setupChord(R.id.chordE, Key.E);
        setupChord(R.id.chordF, Key.F);
        setupChord(R.id.chordG, Key.G);
        setupChord(R.id.chordA, Key.A);
        setupChord(R.id.chordH, Key.H);

        adapter = new ChordsAdapter(this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void setupChord(@IdRes int viewId, Key key) {
        final View rootView = getView();
        if (rootView != null) {
            final CheckedTextView chordView = rootView.findViewById(viewId);
            chordView.setTag(key);
            chordView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    selectOne(chordView);
                }
            });
            chords.add(chordView);
        }
    }

    private void selectOne(CheckedTextView chord) {
        for (CheckedTextView oldChord : chords) {
            oldChord.setChecked(oldChord == chord);
        }
        selectedKey = (Key) chord.getTag();
        adapter.setChords(generateSelectableChords(null));
    }

    private SelectableChord generateSelectableChord(Chord chord, String selectedChordName) {
        return new SelectableChord(chord, chord.getName().equals(selectedChordName));
    }

    private List<SelectableChord> generateSelectableChords(@Nullable String selectedChordName) {
        final List<SelectableChord> selectableItems = new ArrayList<>();
        switch (selectedKey) {
            case C:
                selectableItems.add(generateSelectableChord(new Chord.Builder("C")
                        .addNote(new Note(2, 3, Color.BLUE))
                        .addNote(new Note(3, 2, Color.GREEN))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("C7")
                        .addNote(new Note(2, 3, Color.BLUE))
                        .addNote(new Note(3, 2, Color.GREEN))
                        .addNote(new Note(4, 3, Color.YELLOW))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));
                break;
            case D:
                selectableItems.add(generateSelectableChord(new Chord.Builder("D")
                        .addNote(new Note(3, 0, Color.WHITE))
                        .addNote(new Note(4, 2, Color.RED))
                        .addNote(new Note(5, 3, Color.GREEN))
                        .addNote(new Note(6, 2, Color.BLUE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("Dm")
                        .addNote(new Note(3, 0, Color.WHITE))
                        .addNote(new Note(4, 2, Color.GREEN))
                        .addNote(new Note(5, 3, Color.BLUE))
                        .addNote(new Note(6, 1, Color.RED))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("D7")
                        .addNote(new Note(3, 0, Color.WHITE))
                        .addNote(new Note(4, 2, Color.GREEN))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 2, Color.BLUE))
                        .build(), selectedChordName));
                break;
            case E:
                selectableItems.add(generateSelectableChord(new Chord.Builder("E")
                        .addNote(new Note(1, 0, Color.WHITE))
                        .addNote(new Note(2, 2, Color.GREEN))
                        .addNote(new Note(3, 2, Color.BLUE))
                        .addNote(new Note(4, 1, Color.RED))
                        .addNote(new Note(5, 0, Color.WHITE))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("Em")
                        .addNote(new Note(1, 0, Color.WHITE))
                        .addNote(new Note(2, 2, Color.GREEN))
                        .addNote(new Note(3, 2, Color.BLUE))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(5, 0, Color.WHITE))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("E7")
                        .addNote(new Note(1, 0, Color.WHITE))
                        .addNote(new Note(2, 2, Color.GREEN))
                        .addNote(new Note(3, 0, Color.WHITE))
                        .addNote(new Note(4, 1, Color.RED))
                        .addNote(new Note(5, 0, Color.WHITE))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));
                break;
            case F:
                selectableItems.add(generateSelectableChord(new Chord.Builder("F")
                        .addNote(new Note(3, 3, Color.BLUE))
                        .addNote(new Note(4, 2, Color.GREEN))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 1, Color.RED))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("Fm")
                        .addNote(new Note(1, 1, Color.RED))
                        .addNote(new Note(2, 3, Color.GREEN))
                        .addNote(new Note(3, 3, Color.BLUE))
                        .addNote(new Note(4, 1, Color.RED))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 1, Color.RED))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("F7")
                        .addNote(new Note(1, 1, Color.RED))
                        .addNote(new Note(2, 3, Color.BLUE))
                        .addNote(new Note(3, 1, Color.RED))
                        .addNote(new Note(4, 2, Color.GREEN))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 1, Color.RED))
                        .build(), selectedChordName));
            case G:
                selectableItems.add(generateSelectableChord(new Chord.Builder("G")
                        .addNote(new Note(1, 3, Color.GREEN))
                        .addNote(new Note(2, 2, Color.RED))
                        .addNote(new Note(3, 0, Color.WHITE))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(5, 0, Color.WHITE))
                        .addNote(new Note(6, 3, Color.BLUE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("G7")
                        .addNote(new Note(1, 3, Color.BLUE))
                        .addNote(new Note(2, 2, Color.GREEN))
                        .addNote(new Note(3, 0, Color.WHITE))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(5, 0, Color.WHITE))
                        .addNote(new Note(6, 1, Color.RED))
                        .build(), selectedChordName));
                break;
            case A:
                selectableItems.add(generateSelectableChord(new Chord.Builder("A")
                        .addNote(new Note(2, 0, Color.WHITE))
                        .addNote(new Note(3, 2, Color.BLUE))
                        .addNote(new Note(4, 2, Color.RED))
                        .addNote(new Note(5, 2, Color.GREEN))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("Am")
                        .addNote(new Note(2, 0, Color.WHITE))
                        .addNote(new Note(3, 2, Color.GREEN))
                        .addNote(new Note(4, 2, Color.BLUE))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("A7")
                        .addNote(new Note(2, 0, Color.WHITE))
                        .addNote(new Note(3, 2, Color.BLUE))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(5, 2, Color.GREEN))
                        .addNote(new Note(6, 0, Color.WHITE))
                        .build(), selectedChordName));
                break;
            case H:
                selectableItems.add(generateSelectableChord(new Chord.Builder("H")
                        .addNote(new Note(2, 2, Color.RED))
                        .addNote(new Note(3, 4, Color.YELLOW))
                        .addNote(new Note(4, 4, Color.BLUE))
                        .addNote(new Note(5, 4, Color.GREEN))
                        .addNote(new Note(6, 2, Color.RED))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("Hm")
                        .addNote(new Note(2, 2, Color.RED))
                        .addNote(new Note(3, 4, Color.BLUE))
                        .addNote(new Note(4, 4, Color.YELLOW))
                        .addNote(new Note(5, 3, Color.GREEN))
                        .addNote(new Note(6, 2, Color.RED))
                        .build(), selectedChordName));

                selectableItems.add(generateSelectableChord(new Chord.Builder("H7")
                        .addNote(new Note(2, 2, Color.GREEN))
                        .addNote(new Note(3, 1, Color.RED))
                        .addNote(new Note(4, 2, Color.BLUE))
                        .addNote(new Note(5, 0, Color.WHITE))
                        .addNote(new Note(6, 2, Color.YELLOW))
                        .build(), selectedChordName));
                break;
        }
        return selectableItems;
    }


    @Override
    public void onItemSelected(SelectableChord selectableChord) {
        adapter.setChords(generateSelectableChords(selectableChord.getChord().getName()));

        RealGuitarConnectionManager.getInstance().sendChord(selectableChord.getChord());
    }
}