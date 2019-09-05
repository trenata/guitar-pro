package com.guitar.guitarpro.model;

public class SelectableChord {

    private boolean isSelected;
    private final Chord chord;

    public SelectableChord(Chord chord, boolean isSelected) {
        this.chord = chord;
        this.isSelected = isSelected;
    }

    public Chord getChord() {
        return chord;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
