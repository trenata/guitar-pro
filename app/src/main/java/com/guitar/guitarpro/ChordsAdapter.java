package com.guitar.guitarpro;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.guitar.guitarpro.ChordsAdapter.ChordViewHolder.OnItemSelectedListener;
import com.guitar.guitarpro.model.ChosenChord;
import com.guitar.guitarpro.model.SelectableChord;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ChordsAdapter extends RecyclerView.Adapter<ChordsAdapter.ChordViewHolder> implements ChordsAdapter.ChordViewHolder.OnItemSelectedListener {
    private Context mContext;
    private String[] mChordList;
    OnItemSelectedListener listener;
    private final List<SelectableChord> mValues;


    public static class ChordViewHolder extends RecyclerView.ViewHolder {

        private CheckedTextView mChordName;
        SelectableChord mChord;
        OnItemSelectedListener itemSelectedListener;

        public ChordViewHolder(View itemView, OnItemSelectedListener listener) {
            super(itemView);

            itemSelectedListener = listener;

            mChordName = itemView.findViewById(R.id.chord_text);

            mChordName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    setChecked(true);

                    itemSelectedListener.onItemSelected(mChord);

                }
            });
        }

        public void setChecked(boolean value) {
            if (value) {
                mChordName.setBackgroundColor(R.drawable.chord_bg);
            } else {
                mChordName.setBackground(null);
            }
            mChord.setSelected(value);
            mChordName.setChecked(value);
        }

        public interface OnItemSelectedListener {

            void onItemSelected(SelectableChord item);
        }

        private void bind(String chordName) {
            mChordName.setText(chordName);
        }
    }

    public ChordsAdapter(OnItemSelectedListener listener, List<ChosenChord> chords) {
        this.listener = listener;

        mValues = new ArrayList<>();

        for (ChosenChord item : chords) {
            mValues.add(new SelectableChord(item, false));
        }
    }

    @Override
    public ChordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);
        return new ChordViewHolder(view, (OnItemSelectedListener) this);
    }

    @Override
    public void onBindViewHolder(final ChordViewHolder viewHolder, int position) {
//        holder.bind(mChordList[position]);
//
//        holder.mChordName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                holder.mChordName.toggle();
////                // elkuldeni az Arduinonak
//                System.out.println(determineChordCode(holder.mChordName));
//                makeNote(determineChordCode(holder.mChordName));
////                if(holder.mChordName.getText() == "C")
////                    notesCode = "22A23B24C";
//            }
//        });

        ChordViewHolder holder = viewHolder;
        SelectableChord selectableItem = mValues.get(position);
        String name = selectableItem.getChord();
        holder.mChordName.setText(name);

        TypedValue value = new TypedValue();
        holder.mChordName.getContext().getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorSingle, value, true);
        int checkMarkDrawableResId = value.resourceId;
        holder.mChordName.setCheckMarkDrawable(checkMarkDrawableResId);

        holder.mChord = selectableItem;
        holder.setChecked(holder.mChord.isSelected());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public List<ChosenChord> getSelectedChords() {

        List<ChosenChord> selectedItems = new ArrayList<>();
        for (SelectableChord chord : mValues) {
            if (chord.isSelected()) {
                selectedItems.add(chord);
            }
        }
        return selectedItems;
    }


    @Override
    public void onItemSelected(SelectableChord item) {
        for (SelectableChord selectableItem : mValues) {
            if (!selectableItem.equals(item)
                    && selectableItem.isSelected()) {
                selectableItem.setSelected(false);
            } else if (selectableItem.equals(item)
                    && item.isSelected()) {
                selectableItem.setSelected(true);
            }
        }
        notifyDataSetChanged();
        listener.onItemSelected(item);
    }
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

//    public String determineChordCode(CheckedTextView mChordname) {
//        String code = "";
//        if (mChordname.getText() == "C") {
//            code = "21A42B53C";
//        } else {
//            if (mChordname.getText() == "A") {
//                code = "22C32B42A";
//            } else {
//                if (mChordname.getText() == "Em") {
//                    code = "52A42B";
//                }
//            }
//        }
//        return code;
//    }
//
//    public Color color(char colorCode) {
//        switch (colorCode) {
//            case 'A':
//                return Color.RED;
//            case 'B':
//                return Color.BLUE;
//            case 'C':
//                return Color.GREEN;
//            case 'D':
//                return Color.WHITE;
//            default:
//                return Color.YELLOW;
//        }
//    }
//
//    public void makeNote(String chordCode) {
//        char[] chordCodeArray = chordCode.toCharArray();
//
//        for (int i = 0; i < chordCodeArray.length; i += 3) {
//            new Chord.Builder().addNote(new Note(chordCodeArray[i] - '0', chordCodeArray[i + 1] - '0', color(chordCodeArray[i + 2]))).build();
//        }
//    }

