package org.example.characters;

import org.example.structures.Coord;
import org.example.structures.Direction;

import java.util.Objects;

public abstract class Character {

    private final Coord coord;

    private final String name;

    public Character(Coord coord, String name) {
        this.coord = coord;
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public void move(Direction direction) {
        Coord coord = getCoord();
        coord.setX(coord.getX() + direction.getDx());
        coord.setY(coord.getY() + direction.getDy());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return coord.equals(character.coord) && name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, name);
    }

}
