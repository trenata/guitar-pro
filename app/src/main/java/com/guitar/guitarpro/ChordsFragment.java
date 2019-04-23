package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.guitar.guitarpro.model.*;

import java.util.ArrayList;
import java.util.List;

public class ChordsFragment extends Fragment implements ChordsAdapter.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private ChordsAdapter adapter;
    private List<CheckedTextView> chords = new ArrayList<>();
    private Key selectedKey;

    public ChordsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chords_fragment, null, false);
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
        recyclerView = view.findViewById(R.id.recycler_view);
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
                        .addNote(new Note(6, 0, Color.WHITE))
                        .addNote(new Note(5, 1, Color.RED))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(3, 2, Color.GREEN))
                        .addNote(new Note(2, 3, Color.BLUE))
                        .addNote(new Note(1, 0, Color.WHITE))
                        .build(), selectedChordName));
                break;
            case D:
                break;
            case E:
                selectableItems.add(generateSelectableChord(new Chord.Builder("E")
                        .addNote(new Note(6, 0, Color.WHITE))
                        .addNote(new Note(5, 2, Color.RED))
                        .addNote(new Note(4, 2, Color.WHITE))
                        .addNote(new Note(3, 1, Color.GREEN))
                        .addNote(new Note(2, 0, Color.BLUE))
                        .addNote(new Note(1, 0, Color.WHITE))
                        .build(), selectedChordName));
                selectableItems.add(generateSelectableChord(new Chord.Builder("Em")
                        .addNote(new Note(6, 0, Color.WHITE))
                        .addNote(new Note(5, 2, Color.RED))
                        .addNote(new Note(4, 2, Color.WHITE))
                        .addNote(new Note(3, 0, Color.GREEN))
                        .addNote(new Note(2, 0, Color.BLUE))
                        .addNote(new Note(1, 0, Color.WHITE))
                        .build(), selectedChordName));
                selectableItems.add(generateSelectableChord(new Chord.Builder("E7")
                        .addNote(new Note(6, 0, Color.WHITE))
                        .addNote(new Note(5, 2, Color.RED))
                        .addNote(new Note(4, 0, Color.WHITE))
                        .addNote(new Note(3, 1, Color.GREEN))
                        .addNote(new Note(2, 3, Color.BLUE))
                        .addNote(new Note(1, 0, Color.WHITE))
                        .build(), selectedChordName));
                break;
            case F:
                break;
            case G:
                break;
            case A:
                selectableItems.add(generateSelectableChord(new Chord.Builder("A")
                        .addNote(new Note(5, 0, Color.RED))
                        .addNote(new Note(4, 2, Color.WHITE))
                        .addNote(new Note(3, 2, Color.GREEN))
                        .addNote(new Note(2, 2, Color.BLUE))
                        .addNote(new Note(1, 0, Color.WHITE))
                        .build(), selectedChordName));
                selectableItems.add(generateSelectableChord(new Chord.Builder("Am")
                        .addNote(new Note(5, 0, Color.RED))
                        .addNote(new Note(4, 2, Color.WHITE))
                        .addNote(new Note(3, 2, Color.GREEN))
                        .addNote(new Note(2, 1, Color.BLUE))
                        .addNote(new Note(1, 0, Color.WHITE))
                        .build(), selectedChordName));
                break;
            case H:
                break;
        }
        return selectableItems;
    }


    @Override
    public void onItemSelected(SelectableChord selectableChord) {
        adapter.setChords(generateSelectableChords(selectableChord.getChordName()));
    }
}