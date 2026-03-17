package edu.touro.las.mcon364.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalWarmup {

    /**
     * Problem 1
     * Return a Supplier that gives the current month number (1-12).
     */
    public static Supplier<Integer> currentMonthSupplier() {
        return () -> LocalDate.now().getMonthValue();
    }

    /**
     * Problem 2
     * Return a Predicate that is true only when the input string
     * has more than 5 characters.
     */
    public static Predicate<String> longerThanFive() {
        Predicate<String> longerThanFive = s -> s.length() > 5;
        return longerThanFive;
    }

    /**
     * Problem 3
     * Return a Predicate that checks whether a number is both:
     * - positive
     * - even
     *
     * Prefer chaining smaller predicates.
     */
    public static Predicate<Integer> positiveAndEven() {

        Predicate<Integer> positiveAndEven = x -> x > 0 && x % 2 == 0;
        return positiveAndEven;
    }

    /**
     * Problem 4
     * Return a Function that counts words in a string.
     *
     * Notes:
     * - Trim first.
     * - Blank strings should return 0.
     * - Words are separated by one or more spaces (use can use regex "\\s+")
     *
     */
    public static Function<String, Integer> wordCounter() {
        Function<String, Integer> numWords = s -> s.trim().replaceAll(" ", "").length();
        return numWords;
    }

    /**
     * Problem 5
     * Process the input labels as follows:
     * - remove blank strings
     * - trim whitespace
     * - convert to uppercase
     * - return the final list in the same relative order
     *
     * Example:
     * ["  math ", "", " java", "  "] -> ["MATH", "JAVA"]
     */
    public static List<String> cleanLabels(List<String> labels) {
        Function<String, String> trim = String::trim;
        Function<String, String> removeWhiteSpace = s -> s.replaceAll(" ", "");
        Function<String, String> clean = trim.andThen(String::toUpperCase).andThen(removeWhiteSpace);
        List<String> cleanedLabels = new ArrayList<>();
        for (String label : labels) {
            label = clean.apply(label);
            cleanedLabels.add(clean.apply(label));
        }
        return cleanedLabels;
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("  math ");
        list.add("");
        list.add(" java");
        list.add("  ");
        System.out.println(list);
        System.out.println(cleanLabels(list));
    }
}
