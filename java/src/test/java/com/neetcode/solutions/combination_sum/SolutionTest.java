package com.neetcode.solutions.combination_sum;

import org.junit.jupiter.api.Test;

import com.neetcode.solutions.backtracking.combination_sum.Solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void testBasicCase() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(2, 2, 3),
            Arrays.asList(7)
        );
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testEmptyResult() {
        int[] candidates = {2, 3, 5};
        int target = 1;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        assertTrue(result.isEmpty());
    }

    @Test
    void testMultipleSolutions() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(2, 2, 2, 2),
            Arrays.asList(2, 3, 3),
            Arrays.asList(3, 5)
        );
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
} 