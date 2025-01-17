package com.neetcode.solutions.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(List.of());
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            backtrack(nums, result, current);
            current.remove(current.size() - 1);
        }
    }
    

    public List<List<Integer>> permute2(int[] nums) {
        // Base case: if array is empty, return a list containing an empty list
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        
        // Recursive case:
        // 1. Take all elements except the first one (nums[0])
        // 2. Get permutations of the remaining elements
        List<List<Integer>> perms = permute2(Arrays.copyOfRange(nums, 1, nums.length));

        List<List<Integer>> res = new ArrayList<>();
        // For each permutation of the smaller array
        for (List<Integer> p : perms) {
            // Insert nums[0] at every possible position
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                res.add(p_copy);
            }
        }
        return res;
    }
}

