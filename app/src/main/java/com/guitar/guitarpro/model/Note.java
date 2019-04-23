package com.guitar.guitarpro.model;

public final class Note {
    private static final int MIN_STRING_INDEX = 1;
    private static final int MAX_STRING_INDEX = 6;
    private static final int MIN_FRET_INDEX = 0;
    private static final int MAX_FRET_INDEX = 4;
    private final int stringIndex;
    private final int fretIndex;
    private final Color color;

    public Note(int stringIndex, int fretIndex, Color color) {
        if (stringIndex < MIN_STRING_INDEX || stringIndex > MAX_STRING_INDEX) {
            throw new IllegalArgumentException("The string index must be between " + MIN_STRING_INDEX + " and " + MAX_STRING_INDEX + ".");
        }
        if (fretIndex < MIN_FRET_INDEX || fretIndex > MAX_FRET_INDEX) {
            throw new IllegalArgumentException("The fret index must be between " + MIN_FRET_INDEX + " and " + MAX_FRET_INDEX + ".");
        }
        this.stringIndex = stringIndex;
        this.fretIndex = fretIndex;
        this.color = color;
    }

    public int getStringIndex() {
        return stringIndex;
    }

    public int getFretIndex() {
        return fretIndex;
    }

    public char getColor() {
        switch (color) {
            case RED:
                return 'A';
            case GREEN:
                return 'B';
            case BLUE:
                return 'C';
            case YELLOW:
                return 'D';
            case WHITE:
            default:
                return 'E';
        }
    }
}
