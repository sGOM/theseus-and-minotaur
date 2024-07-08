package org.example.characters;

import org.example.structures.Coord;
import org.example.structures.Direction;
import org.example.structures.Labyrinth;

import java.util.function.BiFunction;

import static org.example.structures.Direction.*;

public class Minotaur extends Character {

    public static final int MOVEMENT = 2;

    public Minotaur(Minotaur other) {
        super(
                new Coord(other.getCoord().getX(), other.getCoord().getY()),
                other.getName()
        );
    }

    public Minotaur(Coord coord, String name) {
        super(coord, name);
    }

    public Direction moveTowards(Theseus theseus, Labyrinth labyrinth) {
        Coord theseusCoord = theseus.getCoord();
        Coord minotaurCoord = getCoord();

        BiFunction<Integer, Integer, Direction> towardHorizontal = (t, m) -> t < m ? L_DIR : (t.equals(m) ? S_DIR : R_DIR);
        BiFunction<Integer, Integer, Direction> towardVertical = (t, m) -> t < m ? U_DIR : (t.equals(m) ? S_DIR : D_DIR);

        Direction direction = towardHorizontal.apply(theseusCoord.getX(), minotaurCoord.getX());
        if (direction != S_DIR && labyrinth.canMove(minotaurCoord, direction)) {
            return direction;
        }

        direction = towardVertical.apply(theseusCoord.getY(), minotaurCoord.getY());
        if (direction != S_DIR && labyrinth.canMove(minotaurCoord, direction)) {
            return direction;
        }

        return Direction.S_DIR;
    }

}
