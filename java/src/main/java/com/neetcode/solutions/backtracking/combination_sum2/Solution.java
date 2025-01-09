package com.neetcode.solutions.backtracking.combination_sum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);  // Sort to handle duplicates
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;   
    }

    /**
     * Helper method that performs depth-first search to find combinations that sum to target.
     * Uses backtracking to try different combinations of numbers.
     */
    private void dfs(int[] candidates, int target, List<Integer> cur, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i-1]) continue;
            
            // Stop if we exceed target
            if (candidates[i] > target) break;
            
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], cur, i + 1);  // Note: i + 1 to use each number once
            cur.remove(cur.size() - 1);
        }
    }
}
