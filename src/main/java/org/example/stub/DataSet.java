package org.example.stub;

import org.example.characters.Minotaur;
import org.example.characters.Theseus;
import org.example.structures.Coord;
import org.example.structures.Labyrinth;

public class DataSet {

    private final Labyrinth labyrinth;

    private final Theseus theseus;

    private final Minotaur minotaur;

    private final Coord escapeCoord;

    public DataSet(Labyrinth labyrinth, Theseus theseus, Minotaur minotaur, Coord escapeCoord) {
        this.labyrinth = labyrinth;
        this.theseus = theseus;
        this.minotaur = minotaur;
        this.escapeCoord = escapeCoord;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public Theseus getTheseus() {
        return theseus;
    }

    public Minotaur getMinotaur() {
        return minotaur;
    }

    public Coord getEscapeCoord() {
        return escapeCoord;
    }
}
