package org.example.structures;

import java.util.Objects;

public class Direction {

    public static final Direction S_DIR = new Direction("S", 0, 0);

    public static final Direction R_DIR = new Direction("R", 1, 0);

    public static final Direction U_DIR = new Direction("U", 0, -1);

    public static final Direction L_DIR = new Direction("L", -1, 0);

    public static final Direction D_DIR = new Direction("D", 0, 1);

    private String name;

    private final int dx;

    private final int dy;

    public Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction(String name, int dx, int dy) {
        this.name = name;
        this.dx = dx;
        this.dy = dy;
    }

    public String getName() {
        return name;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return dx == direction.dx && dy == direction.dy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dx, dy);
    }

}
