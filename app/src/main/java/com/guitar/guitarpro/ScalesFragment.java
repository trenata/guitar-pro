package com.guitar.guitarpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

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

public class ScalesFragment extends Fragment {

    public ScalesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.scales_fragment, null);
    }

}
