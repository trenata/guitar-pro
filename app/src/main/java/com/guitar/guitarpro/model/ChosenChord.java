package com.guitar.guitarpro.model;

public class ChosenChord {

    private String chord;
    private boolean isChosen;

    public ChosenChord(String chord, boolean isChosen) {
        this.chord = chord;
        this.isChosen = isChosen;
    }

    public String getChord() {
        return chord;
    }

    public void setChord(String chord) {
        this.chord = chord;
    }

    public boolean getChosen() {
        return isChosen;
    }

    public void setChosen() {
        this.isChosen = isChosen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        ChosenChord chordCompare = (ChosenChord) obj;
        if (chordCompare.getChord().equals(this.getChord()))
            return true;

        return false;
    }

}
