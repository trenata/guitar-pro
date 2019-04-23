package com.guitar.guitarpro.model;

public class SelectableChord {

    private boolean isSelected;
    private final Chord chord;

    public SelectableChord(Chord chord, boolean isSelected) {
        this.chord = chord;
        this.isSelected = isSelected;
    }

    public String getChordName() {
        return chord.getName();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
