package com.guitar.guitarpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChordsAdapter extends RecyclerView.Adapter<ChordsAdapter.ChordViewHolder> {
    private Context mContext;
    private String[] mChordList;

    public class ChordViewHolder extends RecyclerView.ViewHolder {

        private TextView mChordName;

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
                holder.mChordName.setBackgroundColor(mContext.getColor(R.color.colorPrimary));
//                // elkuldeni az Arduinonak
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChordList.length;
    }
}
