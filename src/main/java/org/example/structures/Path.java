package org.example.structures;

import java.util.HashSet;
import java.util.Set;

import static org.example.structures.Direction.*;

public class Path {

    private final Set<Direction> paths = new HashSet<>(Set.of(S_DIR));

    public Path(String... dirs) {
        for (String d : dirs) {
            switch (d) {
                case "R":
                    paths.add(R_DIR);
                    break;
                case "U":
                    paths.add(U_DIR);
                    break;
                case "L":
                    paths.add(L_DIR);
                    break;
                case "D":
                    paths.add(D_DIR);
                    break;
            }
        }
    }

    public Set<Direction> getPaths() {
        return paths;
    }

    public static Path[][] stringToPath(String[][][] strPath) {
        Path[][] path = new Path[strPath.length][strPath[0].length];

        for (int h = 0; h < strPath.length; h++) {
            for (int w = 0; w < strPath[h].length; w++) {
                path[h][w] = new Path(strPath[h][w]);
            }
        }

        return path;
    }

}
