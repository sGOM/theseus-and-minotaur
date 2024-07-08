package org.example.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Labyrinth {

    private final Map<Coord, Tile> coordTileMap = new HashMap<>();

    private final int width;

    private final int height;

    public Labyrinth(Path[][] path2D) {
        this.height = path2D.length;
        this.width = path2D[0].length;
        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                Coord tileCoord = new Coord(w, h);
                coordTileMap.put(tileCoord, new Tile(tileCoord, path2D[h][w]));
            }
        }
    }

    public int getSize() {
        return coordTileMap.size();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Path getPath(Coord coord) {
        Tile tile = this.coordTileMap.get(coord);
        if (tile == null) {
            return null;
        }
        return tile.getPath();
    }

    public boolean canMove(Coord coord, Direction direction) {
        Set<Direction> coordPaths = coordTileMap.get(coord).getPath().getPaths();

        return coordPaths.contains(direction);
    }

    private class Tile {

        private final Coord coord;

        private final Path path;

        public Tile(Coord coord, Path path) {
            this.coord = coord;
            this.path = path;
        }

        public Coord getCoord() {
            return coord;
        }

        public Path getPath() {
            return path;
        }
    }

}
