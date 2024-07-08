package org.example;

import org.example.stub.DataSet;
import org.example.stub.TestData;

public class Main {

    public static void main(String[] args) {
        DataSet dataSet = TestData.puzzle5;

        Solution solution = new Solution(
                dataSet.getLabyrinth(),
                dataSet.getEscapeCoord(),
                dataSet.getTheseus(),
                dataSet.getMinotaur()
        );
        System.out.printf("BFS:%n %s%n%n", solution.bfsSolution());
        System.out.printf("Dijkstra:%n %s%n%n", solution.dijkstraSolution());
        System.out.printf("A*:%n %s%n%n", solution.aStarSolution());
        System.out.printf("Precomputed Distance A*:%n %s%n%n", solution.aStarSolutionWithPrecomputedDistance());
    }

}
