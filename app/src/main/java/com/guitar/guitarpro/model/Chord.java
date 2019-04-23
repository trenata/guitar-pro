package com.guitar.guitarpro.model;

import java.util.ArrayList;
import java.util.List;

public final class Chord {

    private final List<Note> notes;
    private final String name;

    private Chord(List<Note> notes, String name) {
        if (notes.isEmpty()) {
            throw new IllegalArgumentException("The chord must contain at least one note.");
        }
        this.notes = notes;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private final List<Note> notes = new ArrayList<>();
        private final String name;

        public Builder(String name) {
            this.name = name;
        }

        public Builder addNote(Note note) {
            notes.add(note);
            return this;
        }

        public Chord build() {
            return new Chord(notes, name);
        }
    }

}