package com.guitar.guitarpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.guitar.guitarpro.model.Chord;
import com.guitar.guitarpro.model.Color;
import com.guitar.guitarpro.model.Note;

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
                System.out.println(determineChordCode(holder.mChordName));
                makeNote(determineChordCode(holder.mChordName));
//                if(holder.mChordName.getText() == "C")
//                    notesCode = "22A23B24C";
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChordList.length;
    }


//    public int determineNoteNumber(CheckedTextView mChordName) {
//        if (mChordName.getText() == "C" || mChordName.getText() == "E" || mChordName.getText() == "A" || mChordName.getText() == "G" || mChordName.getText() == "Am" || mChordName.getText() == "D" || mChordName.getText() == "Dm") {
//            return 3;
//        }
//        if (mChordName.getText() == "Cm" || mChordName.getText() == "H" || mChordName.getText() == "Hm" || mChordName.getText() == "F") {
//            return 9;
//        }
//        if (mChordName.getText() == "Fm" || mChordName.getText() == "Gm") {
//            return 8;
//        }
//        return 2;
//    }

    public String determineChordCode(CheckedTextView mChordname) {
        String code = "";
        if (mChordname.getText() == "C") {
            code = "21A42B53C";
        } else {
            if (mChordname.getText() == "A") {
                code = "22C32B42A";
            } else {
                if (mChordname.getText() == "Em") {
                    code = "52A42B";
                }
            }
        }
        return code;
    }

    public Color color(char colorCode) {
        switch (colorCode) {
            case 'A':
                return Color.RED;
            case 'B':
                return Color.BLUE;
            case 'C':
                return Color.GREEN;
            case 'D':
                return Color.WHITE;
            default:
                return Color.YELLOW;
        }
    }

    public void makeNote(String chordCode) {
        char[] chordCodeArray = chordCode.toCharArray();

        for (int i = 0; i < chordCodeArray.length; i += 3) {
            new Chord.Builder().addNote(new Note(chordCodeArray[i] - '0', chordCodeArray[i + 1] - '0', color(chordCodeArray[i + 2]))).build();
        }
    }
}

