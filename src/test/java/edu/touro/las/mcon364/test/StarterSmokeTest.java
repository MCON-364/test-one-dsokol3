package edu.touro.las.mcon364.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StarterSmokeTest {
    @Test
    void starterProjectCompiles() {
        assertTrue(true);
    }

    /*
    * Example:
     ["  math ", "", " java", "  "] -> ["MATH", "JAVA"]
    * */
    @Test
    void TestCleanLabels() {
        ArrayList<String> list = new ArrayList<>();
        list.add("  math ");
        list.add("");
        list.add(" java");
        list.add("  ");
        assertTrue(list.contains("math"));
        assertTrue(list.contains("java"));
        assertFalse(list.contains(" "));

    }
}
