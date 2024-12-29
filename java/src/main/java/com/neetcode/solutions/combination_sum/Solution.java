package com.neetcode.solutions.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, target, new ArrayList<>(), 0);
        return res;        
    }

    /**
     * Helper method that performs depth-first search to find combinations that sum to target.
     * Uses backtracking to try different combinations of numbers.
     * 
     * @param nums Array of candidate numbers to use
     * @param target Remaining target sum to reach
     * @param cur Current combination being built
     * @param i Current index in nums array being considered
     * @return void - Results are added to res list field
     */
    private void dfs(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        dfs(nums, target-nums[i], cur, i);
        cur.remove(cur.size() - 1);
        dfs(nums, target, cur, i+1);
    }
}
