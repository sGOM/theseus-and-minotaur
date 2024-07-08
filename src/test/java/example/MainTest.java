package example;

import org.example.Solution;
import org.example.stub.DataSet;
import org.example.stub.TestData;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class MainTest {

    DataSet dataSet = TestData.puzzle7;

    Solution solution = new Solution(
            dataSet.getLabyrinth(),
            dataSet.getEscapeCoord(),
            dataSet.getTheseus(),
            dataSet.getMinotaur()
    );

    @Test
    public void testBfs() {
        // Given
        // When
        runAndMeasure("BFS Solution", solution::bfsSolution);
        // Then
    }

    @Test
    public void testDijkstra() {
        // Given
        // When
        runAndMeasure("Dijkstra Solution", solution::dijkstraSolution);
        // Then
    }

    @Test
    public void testAStar() {
        // Given
        // When
        runAndMeasure("A* Solution", solution::aStarSolution);
        // Then
    }

    @Test
    public void testAStarWithPrecomputedDistance() {
        // Given
        // When
        runAndMeasure("A* with Precomputed Distance Solution", solution::aStarSolutionWithPrecomputedDistance);
        // Then
    }

    void runAndMeasure(String solutionName, Supplier<String> solutionMethod) {
        long startTime = System.nanoTime();
        String answer = solutionMethod.get();
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000.0;  // compute the elapsed time
        System.out.printf("%s Execution time : %fms%n", solutionName, duration);
        System.out.println("Answer: " + answer);
        System.out.println();
    }

}
