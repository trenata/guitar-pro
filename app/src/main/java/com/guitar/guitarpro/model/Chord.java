package com.guitar.guitarpro.model;

import java.util.ArrayList;
import java.util.List;

public final class Chord {

    private final List<Note> notes;

    private Chord(List<Note> notes) {
        if (notes.isEmpty()) {
            throw new IllegalArgumentException("The chord must contain at least one note.");
        }
        this.notes = notes;
    }

    public class Builder {
        private final List<Note> notes = new ArrayList<>();

        Builder addNote(Note note) {
            notes.add(note);
            return this;
        }

        Chord build() {
            return new Chord(notes);
        }
    }

}