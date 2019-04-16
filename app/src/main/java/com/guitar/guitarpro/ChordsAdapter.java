package com.guitar.guitarpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChordsAdapter extends RecyclerView.Adapter<ChordsAdapter.ChordViewHolder> {
    private Context mContext;
    private String[] mChordList;

    public class ChordViewHolder extends RecyclerView.ViewHolder {

        private CheckedTextView mChordName;

        private ChordViewHolder(View itemView) {
            super(itemView);

            mChordName = itemView.findViewById(R.id.chord_text);
        }

        private void bind(String chordName) {
            mChordName.setText(chordName);
        }
    }

    public ChordsAdapter(Context mContext, String[] mChordList) {
        this.mContext = mContext;
        this.mChordList = mChordList;
    }

    @Override
    public ChordsAdapter.ChordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);
        return new ChordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChordViewHolder holder, int position) {
        holder.bind(mChordList[position]);

        holder.mChordName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mChordName.toggle();
//                // elkuldeni az Arduinonak
//                new Chord.Builder().addNote(new Note()).addNote(new Note()).addNote(new Note()).build();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChordList.length;
    }
}
