package org.example;

import org.example.characters.Minotaur;
import org.example.characters.Theseus;
import org.example.structures.Coord;
import org.example.structures.Direction;
import org.example.structures.Labyrinth;
import org.example.structures.Path;

import java.util.*;

public class Solution {

    final Labyrinth labyrinth;

    final Coord escapeCoord;

    final Theseus startingTheseus;

    final Minotaur startingMinotaur;

    final String NO_SOLUTION = "No solution!";

    public Solution(Labyrinth labyrinth, Coord escapeCoord, Theseus startingTheseus, Minotaur startingMinotaur) {
        this.labyrinth = labyrinth;
        this.escapeCoord = escapeCoord;
        this.startingTheseus = startingTheseus;
        this.startingMinotaur = startingMinotaur;
    }

    public String bfsSolution() {
        State startingState = new State(startingTheseus, startingMinotaur);
        Queue<State> queue = new LinkedList<>(List.of(startingState));
        Set<State> discovered = new HashSet<>(Set.of(startingState));

        while(!queue.isEmpty()) {
            State current = queue.poll();

            for (State nextState : nextTheseusPosition(current)) {
                if (checkEscape(nextState)) {
                    return nextState.getTheseusMoveLog();
                }

                nextMinotaurPosition(nextState);
                if (!nextState.isTheseusCaptured() && discovered.add(nextState)) {
                    queue.add(nextState);
                }
            }
        }

        return NO_SOLUTION;
    }

    public String dijkstraSolution() {
        State startingState = new State(startingTheseus, startingMinotaur);
        Queue<State> queue = new LinkedList<>(List.of(startingState));
        Map<State, State> discovered = new HashMap<>(Map.of(startingState, startingState));

        while(!queue.isEmpty()) {
            State current = discovered.get(queue.poll());

            for (State nextState : nextTheseusPosition(current)) {
                if (checkEscape(nextState)) {
                    return nextState.getTheseusMoveLog();
                }

                nextMinotaurPosition(nextState);
                State oldState = discovered.get(nextState);
                if (nextState.isTheseusCaptured() || (oldState != null && oldState.getTheseusMoveLog().length() <= nextState.getTheseusMoveLog().length())) {
                    continue;
                }
                discovered.put(nextState, nextState);
                queue.add(nextState);
            }
        }

        return NO_SOLUTION;
    }

    public String aStarSolution() {
        State startingState = new State(startingTheseus, startingMinotaur);
        PriorityQueue<Map.Entry<Integer, State>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        queue.add(Map.entry(naiveHeuristic(startingState), startingState));
        Map<State, State> discovered = new HashMap<>(Map.of(startingState, startingState));

        while(!queue.isEmpty()) {
            State current = discovered.get(queue.poll().getValue());

            for (State nextState : nextTheseusPosition(current)) {
                if (checkEscape(nextState)) {
                    return nextState.getTheseusMoveLog();
                }

                nextMinotaurPosition(nextState);
                State oldState = discovered.get(nextState);
                if (nextState.isTheseusCaptured() || (oldState != null && oldState.getTheseusMoveLog().length() <= nextState.getTheseusMoveLog().length())) {
                    continue;
                }
                discovered.put(nextState, nextState);
                queue.add(Map.entry(naiveHeuristic(nextState), nextState));
            }
        }

        return NO_SOLUTION;
    }

    public String aStarSolutionWithPrecomputedDistance() {
        HashMap<Coord, Integer> precomputedDistance = new HashMap<>();
        initPrecomputedDistance(precomputedDistance);

        State startingState = new State(startingTheseus, startingMinotaur);
        PriorityQueue<Map.Entry<Integer, State>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        queue.add(Map.entry(naiveHeuristic(startingState, precomputedDistance), startingState));
        Map<State, State> discovered = new HashMap<>(Map.of(startingState, startingState));

        while(!queue.isEmpty()) {
            State current = discovered.get(queue.poll().getValue());

            for (State nextState : nextTheseusPosition(current)) {
                if (checkEscape(nextState)) {
                    return nextState.getTheseusMoveLog();
                }

                nextMinotaurPosition(nextState);
                State oldState = discovered.get(nextState);
                if (nextState.isTheseusCaptured() || (oldState != null && oldState.getTheseusMoveLog().length() <= nextState.getTheseusMoveLog().length())) {
                    continue;
                }
                discovered.put(nextState, nextState);
                queue.add(Map.entry(naiveHeuristic(nextState, precomputedDistance), nextState));
            }
        }

        return NO_SOLUTION;
    }

    public void initPrecomputedDistance(HashMap<Coord, Integer> precomputedDistance) {
        for (int x = 0; x < labyrinth.getWidth(); x++) {
            for (int y = 0; y < labyrinth.getHeight(); y++) {
                precomputedDistance.put(new Coord(x, y), Integer.MAX_VALUE);
            }
        }

        precomputedDistance.put(escapeCoord, 0);
        Queue<Coord> queue = new LinkedList<>();
        List.of(Direction.R_DIR, Direction.D_DIR, Direction.L_DIR, Direction.U_DIR).forEach(direction -> {
            Coord neighbor = new Coord(escapeCoord.getX() + direction.getDx(), escapeCoord.getY() + direction.getDy());
            if (precomputedDistance.containsKey(neighbor)) {
                precomputedDistance.put(neighbor, precomputedDistance.get(escapeCoord) + 1);
                queue.add(neighbor);
            }
        });

        while (!queue.isEmpty()) {
            Coord current = queue.poll();
            labyrinth.getPath(current).getPaths().forEach(direction -> {
                Coord neighbor = new Coord(current.getX() + direction.getDx(), current.getY() + direction.getDy());
                if (precomputedDistance.get(neighbor) == Integer.MAX_VALUE) {
                    precomputedDistance.put(neighbor, precomputedDistance.get(current) + 1);
                    queue.add(neighbor);
                }
            });
        }
    }

    public int naiveHeuristic(State state) {
        Theseus theseus = state.getTheseus();

        return theseus.getCoord().manhattanDistance(escapeCoord) + state.getTheseusMoveLog().length();
    }

    public int naiveHeuristic(State state, HashMap<Coord, Integer> precomputedDistance) {
        Theseus theseus = state.getTheseus();

        return precomputedDistance.get(theseus.getCoord());
    }

    public List<State> nextTheseusPosition(State state) {
        List<State> statesList = new LinkedList<>();

        Theseus theseus = state.getTheseus();
        Path paths = labyrinth.getPath(theseus.getCoord());

        for (Direction direction : paths.getPaths()) {
            State nextState = new State(state);
            nextState.getTheseus().move(direction);
            nextState.appendTheseusMoveLog(direction);

            statesList.add(nextState);
        }

        return statesList;
    }

    public void nextMinotaurPosition(State state) {
        Minotaur minotaur = state.getMinotaur();
        Theseus theseus = state.getTheseus();

        for (int i = 0; i < Minotaur.MOVEMENT; i++) {
            Direction direction = minotaur.moveTowards(theseus, labyrinth);
            minotaur.move(direction);
        }
    }

    public boolean checkEscape(State state) {
        return state.getTheseus().getCoord().equals(escapeCoord);
    }

    private class State {

        private final Theseus theseus;

        private final Minotaur minotaur;

        private StringBuilder theseusMoveLog = new StringBuilder();

        public State(State other) {
            this.theseus = new Theseus(other.theseus);
            this.minotaur = new Minotaur(other.minotaur);
            this.theseusMoveLog = new StringBuilder(other.theseusMoveLog);
        }

        public State(Theseus theseus, Minotaur minotaur) {
            this.theseus = theseus;
            this.minotaur = minotaur;
        }

        public Theseus getTheseus() {
            return theseus;
        }

        public Minotaur getMinotaur() {
            return minotaur;
        }

        public String getTheseusMoveLog() {
            return theseusMoveLog.toString();
        }

        public boolean isTheseusCaptured() {
            return theseus.getCoord().equals(minotaur.getCoord());
        }

        public void appendTheseusMoveLog(Direction direction) {
            theseusMoveLog.append(direction.getName());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(theseus, state.theseus) && Objects.equals(minotaur, state.minotaur);
        }

        @Override
        public int hashCode() {
            return Objects.hash(theseus, minotaur);
        }
    }

}
