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

    ChordsAdapter(OnItemSelectedListener listener) {
        this.listener = listener;
        mValues = new ArrayList<>();
    }

    @NonNull
    @Override
    public ChordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChordViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false), new ChordViewHolder.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onItemSelected(mValues.get(position));
            }
        });
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

    static class ChordViewHolder extends RecyclerView.ViewHolder {

        public interface OnItemSelectedListener {

            void onItemSelected(int position);
        }

        private CheckedTextView mChordName;

        ChordViewHolder(View itemView, final OnItemSelectedListener listener) {
            super(itemView);
            mChordName = itemView.findViewById(R.id.chord_text);
            mChordName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        listener.onItemSelected(adapterPosition);
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