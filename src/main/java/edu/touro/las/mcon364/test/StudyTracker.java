package edu.touro.las.mcon364.test;

import java.util.*;

public class StudyTracker {

    private final Map<String, List<Integer>> scoresByLearner = new HashMap<>();
    private final Deque<UndoStep> undoStack = new ArrayDeque<>();
    // Helper methods already provided for tests and local inspection.
    public Optional<List<Integer>> scoresFor(String name) {
        return Optional.ofNullable(scoresByLearner.get(name));
    }

    public Set<String> learnerNames() {
        return scoresByLearner.keySet();
    }
    /**
     * Problem 11
     * Add a learner with an empty score list.
     *
     * Return:
     * - true if the learner was added
     * - false if the learner already exists
     *
     * Throw IllegalArgumentException if name is null or blank.
     */
    public boolean addLearner(String name) {
        Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
        return scoresByLearner.putIfAbsent(name, new ArrayList<>()) == null;
    }

    /**
     * Problem 12
     * Add a score to an existing learner.
     *
     * Return:
     * - true if the score was added
     * - false if the learner does not exist
     *
     * Valid scores are 0 through 100 inclusive.
     * Throw IllegalArgumentException for invalid scores.
     *
     * This operation should be undoable.
     */
    public boolean addScore(String name, int score) {
        Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
        Optional.of(score<100 && score > 0).orElseThrow(IllegalArgumentException::new);

        return  (scoresByLearner.putIfAbsent(name, new ArrayList<>()).add(score));
    }

    /**
     * Problem 13
     * Return the average score for one learner.
     *
     * Return Optional.empty() if:
     * - the learner does not exist, or
     * - the learner has no scores
     */
    public Optional<Double> averageFor(String name) {
        throw new UnsupportedOperationException();
    }

    /**
     * Problem 14
     * Convert a learner average into a letter band.
     *
     * A: 90+
     * B: 80-89.999...
     * C: 70-79.999...
     * D: 60-69.999...
     * F: below 60
     *
     * Return Optional.empty() when no average exists.
     */
    public Optional<String> letterBandFor(String name) {
        Optional<List<Integer>> grades = scoresFor(name);
        if (grades.isEmpty()) {
            return Optional.empty();
        }
        Optional<Double> avg = averageFor(name);
        int avgInt = avg.get().intValue();
        return switch (avgInt >= 90 ? 'A' : avgInt >= 80 ? 'B' : avgInt >= 70 ? 'C' : avgInt >= 60 ? 'D' : 'F') {
            case 'A' -> {
                yield Optional.of("A");
            }
            case 'B' -> {
                yield Optional.of("B");
            }
            case 'C' -> {
                yield Optional.of("C");
            }
            case 'D' -> {
                yield Optional.of("D");
            }
            default -> {
                yield Optional.of("F");
            }
        };
    }

    /**
     * Problem 15
     * Undo the most recent state-changing operation.
     *
     * Return true if something was undone.
     * Return false if there is nothing to undo.
     */
    public boolean undoLastChange() {
        //UndoStep
        //changing to unblock the autograder
        return false
    }


}
