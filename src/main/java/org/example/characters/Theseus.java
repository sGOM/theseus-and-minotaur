package org.example.characters;

import org.example.structures.Coord;

public class Theseus extends Character {

    public Theseus(Theseus other) {
        super(
                new Coord(other.getCoord().getX(), other.getCoord().getY()),
                other.getName()
        );
    }

    public Theseus(Coord coord, String name) {
        super(coord, name);
    }

}
