package org.example.stub;

import org.example.characters.Minotaur;
import org.example.characters.Theseus;
import org.example.structures.Coord;
import org.example.structures.Labyrinth;
import org.example.structures.Path;

public class TestData {

    private static final String R = "R";

    private static final String D = "D";

    private static final String L = "L";

    private static final String U = "U";

    public static final DataSet example1 = new DataSet(
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R, D}, {R, L}, {D, L}},
                    {{U, R, D}, {L}, {U, R, D}},
                    {{U, R}, {R, L}, {U, L}}
            })),
            new Theseus(new Coord(1, 2), "테세우스"),
            new Minotaur(new Coord(1, 0), "미노타우르스"),
            new Coord(3, 1)
    );

    public static final DataSet example2 = new DataSet(
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R, D}, {R, L}, {D, L}},
                    {{U, R, D}, {R, D, L}, {U, R, D, L}},
                    {{U}, {U, R, D}, {U, D, L}},
                    {{R}, {U, R, L}, {U, L}}
            })),
            new Theseus(new Coord(1, 1), "테세우스"),
            new Minotaur(new Coord(1, 0), "미노타우르스"),
            new Coord(3, 1)
    );

    public static final DataSet example3 = new DataSet(
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R, D}, {R, D, L}, {R, D, L}, {R, D, L}, {R, D, L}, {R, D, L}, {D, L}},
                    {{U, D}, {U}, {U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, D, L}},
                    {{U, R, D}, {R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, D, L}, {U}, {U, D}},
                    {{U, R}, {U, R, D, L}, {U, R, L}, {U, R, L}, {U, R, L}, {R, L}, {U, L}},
            })),
            new Theseus(new Coord(2, 1), "테세우스"),
            new Minotaur(new Coord(0, 1), "미노타우르스"),
            new Coord(1, 4)
    );

    public static final DataSet puzzle1 = new DataSet(
            // 6x6
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R}, {R, D, L}, {R, D, L}, {R, D, L}, {U, D, L}, {D}},
                    {{R, D}, {U, L}, {U, R, D}, {U, D, L}, {U}, {U, D}},
                    {{U, D}, {D}, {U}, {U, R, D}, {R, L}, {U, D, L}},
                    {{U, D}, {U, R, D}, {R, L}, {U, D, L}, {R, D}, {U, D, L}},
                    {{U, D}, {U, D}, {R, D}, {U, R, D, L}, {U, R, D, L}, {U, D, L}},
                    {{U, R}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, L}},
            })),
            new Theseus(new Coord(0, 0), "테세우스"),
            new Minotaur(new Coord(4, 2), "미노타우르스"),
            new Coord(4, -1)
    );

    public static final DataSet puzzle2 = new DataSet(
            // 6x6
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R, D}, {U, R, L}, {R, D, L}, {R, D, L}, {L}, {D}},
                    {{U, R, D}, {R, D, L}, {U, D, L}, {U, R, D}, {R, L}, {U, D, L}},
                    {{U, R, D}, {U, R, D, L}, {U, D, L}, {U, R, D}, {D, L}, {U, D}},
                    {{U}, {U, R, D}, {U, R, D, L}, {U, D, L}, {U}, {U, D}},
                    {{R, D}, {U, R, D, L}, {U, R, L}, {U, R, D, L}, {D, L}, {U, D}},
                    {{U, R}, {U, R, L}, {R, L}, {U, R, L}, {U, R, L}, {U, L}},
            })),
            new Theseus(new Coord(4, 4), "테세우스"),
            new Minotaur(new Coord(0, 4), "미노타우르스"),
            new Coord(1, -1)
    );

    public static final DataSet puzzle3 = new DataSet(
            // 8x9
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R}, {R, L}, {R, D, L}, {D, L}, {R, D}, {D, L}, {R, D}, {R, L}, {D, L}},
                    {{R, D}, {D, L}, {U}, {U, D}, {U, D}, {U, D}, {U, R, D}, {L}, {U, D}},
                    {{U, D}, {U, R}, {D, L}, {U, R, D}, {U, L}, {U, R}, {U, L}, {R, D}, {U, D, L}},
                    {{U, R}, {D, L}, {U, D}, {U, R}, {D, L}, {R, D}, {R, L}, {U, R, L}, {U, L}},
                    {{D}, {U, D}, {U, R}, {R, D, L}, {U, L}, {U, R}, {R, L}, {R, L}, {D, L}},
                    {{U, R, D}, {U, L}, {R, D}, {U, L}, {R, D}, {R, D, L}, {R, L}, {R, L}, {U, L}},
                    {{U, D}, {D}, {U, R, D}, {L}, {U, D}, {U, R}, {R, L}, {R, L}, {D, L}},
                    {{U}, {U, R, D}, {U, R, L}, {R, L}, {U, R, L}, {L}, {R}, {R, L}, {U, L}},
            })),
            new Theseus(new Coord(0, 0), "테세우스"),
            new Minotaur(new Coord(2, 2), "미노타우르스"),
            new Coord(1, 8)
    );

    public static final DataSet puzzle4 = new DataSet(
            // 8x9
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R}, {R, L}, {R, D, L}, {U, R, D, L}, {R, D, L}, {R, L}, {R, D, L}, {R, D, L}, {D, L}},
                    {{R, D}, {R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, D, L}},
                    {{U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, D, L}},
                    {{U, D}, {U, R}, {U, D, L}, {D}, {U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, D, L}, {U, D}},
                    {{U, D}, {R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, L}, {U, D}},
                    {{U, D}, {U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {D, L}, {U, D}},
                    {{U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, D, L}, {U, D}},
                    {{U, R}, {U, R, L}, {U, R, L}, {R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, L}},
            })),
            new Theseus(new Coord(8, 0), "테세우스"),
            new Minotaur(new Coord(0, 0), "미노타우르스"),
            new Coord(3, -1)
    );

    public static final DataSet puzzle5 = new DataSet(
            // 8x8
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{D, L}, {R, D}, {R, D, L}, {R, D, L}, {R, D, L}, {R, L}, {R, D, L}, {L}},
                    {{U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {R, D, L}, {U, D, L}, {D}},
                    {{U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, R, D, L}, {U, D, L}, {U, R, D}, {U, R, D, L}, {U, D, L}},
                    {{U, R, D}, {U, R, L}, {U, R, D, L}, {U, D, L}, {U, R, D}, {U, R, L}, {U, R, D, L}, {U, D, L}},
                    {{U, R, D}, {R, D, L}, {U, D, L}, {U, R, D}, {U, R, D, L}, {R, D, L}, {U, R, D, L}, {U, D, L}},
                    {{U}, {U, D}, {U, R, D}, {U, R, D, L}, {U, R, D, L}, {U, D, L}, {U, R}, {U, D, L}},
                    {{R}, {U, D, L}, {U, R, D}, {U, D, L}, {U, R}, {U, R, D, L}, {R, D, L}, {U, D, L}},
                    {{R}, {U, R, L}, {U, R, L}, {U, R, L}, {L}, {U, R}, {U, R, L}, {U, L}},
            })),
            new Theseus(new Coord(1, 1), "테세우스"),
            new Minotaur(new Coord(0, 0), "미노타우르스"),
            new Coord(-1, 0)
    );

    public static final DataSet puzzle6 = new DataSet(
            // 9x14
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R}, {L, R}, {R, D, L}, {R, D, L}, {D, L}, {R, D}, {R, L}, {R, D, L}, {L}, {R}, {R, D, L}, {R, L}, {R, L}, {D, L}},
                    {{D}, {D}, {U, D}, {U}, {U, D}, {U, D}, {R}, {U, R, D, L}, {R, L}, {R, L}, {U, L}, {R}, {R, L}, {U, R, D, L}},
                    {{U, R, D}, {U, R, D, L}, {U, R, L}, {R, D, L}, {U, R, D, L}, {U, R, D, L}, {R, L}, {U, R, D, L}, {R, D, L}, {R, D, L}, {R, L}, {R, L}, {R, D, L}, {U, D, L}},
                    {{U, D}, {U, D}, {R}, {U, D, L}, {U, D}, {U, R, D}, {R, D, L}, {U, D, L}, {U, D}, {U, R}, {R, L}, {R, L}, {U, D, L}, {U, D}},
                    {{U, D}, {U, D}, {R, D}, {U, D, L}, {U, D}, {U, D}, {U, D}, {U, D}, {U, R, D}, {R, L}, {R, L}, {D, L}, {U, D}, {U, D}},
                    {{U, D}, {U, D}, {U, D}, {U, R, D}, {U, D, L}, {U, D}, {U, R, D}, {U, R, D, L}, {U, R, D, L}, {R, L}, {R, L}, {U, D, L}, {U, D}, {U, D}},
                    {{U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, R, D}, {R, L}, {R, L}, {U, D, L}, {U, D}, {U, D}},
                    {{U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, R, D}, {R, L}, {R, L}, {U, D, L}, {U, D}, {U, D}},
                    {{U, R}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {U, R, L}, {R, L}, {R, L}, {U, R, L}, {U, R, L}, {U, L}},
            })),
            new Theseus(new Coord(0, 4), "테세우스"),
            new Minotaur(new Coord(13, 4), "미노타우르스"),
            new Coord(14, 1)
    );

    public static final DataSet puzzle7 = new DataSet(
            // 9x14
            new Labyrinth(Path.stringToPath(new String[][][] {
                    {{R, D}, {D, L}, {R, D}, {R, L}, {R, D, L}, {R, L}, {R, L}, {R, D, L}, {R, D, L}, {L}, {R, D}, {R, L}, {R, L}, {D, L}},
                    {{U, D}, {U, R}, {U, R, L}, {D, L}, {U, D}, {R, D}, {R, L}, {U, D, L}, {U, R, D}, {L}, {U, D}, {D}, {D}, {U, D}},
                    {{U, R, D}, {D, L}, {R, D}, {U, R, L}, {U, R, L}, {U, R, D, L}, {R, L}, {U, R, D, L}, {U, R, L}, {D, L}, {U, D}, {U, R, D}, {U, R, D, L}, {U, D, L}},
                    {{U, D}, {U, R, D}, {U, R, D, L}, {R, D, L}, {D, L}, {U, D}, {R}, {U, R, D, L}, {D, L}, {U, R, D}, {U, D, L}, {U, D}, {U, D}, {U, D}},
                    {{U, D}, {U, D}, {U, D}, {U, D}, {U, D}, {U, R, D}, {D, L}, {U, D}, {U, D}, {U, D}, {U, D}, {U, R, D}, {U, R, L}, {U, L}},
                    {{U, R, D}, {U, R, L}, {U, R, L}, {U, R, L}, {U, D, L}, {U, D}, {U, R, D}, {U, D, L}, {U, D}, {U, D}, {U, D}, {U, D}, {D}, {D, R}},
                    {{U, R}, {R, L}, {R, D, L}, {D, L}, {U, R}, {U, R, L}, {U, D, L}, {U, R, D}, {U, R, L}, {U, D, L}, {U, R}, {U, R, D, L}, {U, L}, {U, D}},
                    {{D}, {D}, {U, D}, {U, D}, {R}, {R, L}, {U, D, L}, {U, R, D}, {R, D, L}, {U, R, L}, {R, L}, {U, R, L}, {D, L}, {U, D}},
                    {{U, R}, {U, R, L}, {U, R, L}, {U, R, L}, {R, L}, {R, L}, {U, R, L}, {U, L}, {U, R}, {R, L}, {R, L}, {R, L}, {U, R, L}, {U, L}},
            })),
            new Theseus(new Coord(12, 5), "테세우스"),
            new Minotaur(new Coord(6, 3), "미노타우르스"),
            new Coord(14, 5)
    );

}
