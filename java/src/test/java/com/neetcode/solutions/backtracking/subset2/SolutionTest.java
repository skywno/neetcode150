package com.neetcode.solutions.backtracking.subset2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 1};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        // Expected subsets: [[],[1],[1,2],[1,1],[1,2,1],[2]]
        Set<List<Integer>> expected = new HashSet<>(Arrays.asList(
            Arrays.asList(),
            Arrays.asList(1),
            Arrays.asList(1, 2),
            Arrays.asList(1, 1),
            Arrays.asList(1, 2, 1),
            Arrays.asList(2)
        ));
        
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void testExample2() {
        int[] nums = {7, 7}; 
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        // Expected subsets: [[],[7],[7,7]]
        Set<List<Integer>> expected = new HashSet<>(Arrays.asList(
            Arrays.asList(),
            Arrays.asList(7),
            Arrays.asList(7, 7)
        ));
        
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertTrue(new HashSet<>(result).containsAll(expected));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {5};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        Set<List<Integer>> expected = new HashSet<>(Arrays.asList(
            Arrays.asList(),
            Arrays.asList(5)
        ));
        
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertTrue(new HashSet<>(result).containsAll(expected));
    }
} 