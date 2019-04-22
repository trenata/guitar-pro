package com.guitar.guitarpro.model;

import android.content.ClipData;

public class SelectableChord extends ChosenChord {

    private boolean isSelected = false;


    public SelectableChord(ChosenChord chord, boolean isSelected) {
        super(chord.getChord(), chord.getChosen());
        this.isSelected = isSelected;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
