package com.guitar.guitarpro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.guitar.guitarpro.model.SelectableChord;

import java.util.ArrayList;
import java.util.List;

public class ChordsAdapter extends RecyclerView.Adapter<ChordsAdapter.ChordViewHolder> {

    public interface OnItemSelectedListener {

        void onItemSelected(SelectableChord item);
    }

    private final OnItemSelectedListener listener;
    private List<SelectableChord> mValues;

    ChordsAdapter(@NonNull OnItemSelectedListener listener) {
        this.listener = listener;
        mValues = new ArrayList<>();
    }

    @NonNull
    @Override
    public ChordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChordViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ChordViewHolder viewHolder, int position) {
        viewHolder.bind(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    void setChords(List<SelectableChord> mValues) {
        this.mValues = mValues;
        notifyDataSetChanged();
    }

    class ChordViewHolder extends RecyclerView.ViewHolder {

        private CheckedTextView mChordName;

        ChordViewHolder(View itemView) {
            super(itemView);
            mChordName = itemView.findViewById(R.id.chord_text);
            mChordName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        listener.onItemSelected(mValues.get(adapterPosition));
                    }
                }
            });
        }

        void bind(SelectableChord chord) {
            mChordName.setText(chord.getChordName());
            mChordName.setChecked(chord.isSelected());
        }
    }
}