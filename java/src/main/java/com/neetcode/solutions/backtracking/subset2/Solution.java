package com.neetcode.solutions.backtracking.subset2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> current, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        backtrack(nums, current, i+1);
        current.remove(current.size() - 1);


        while (i < nums.length - 1 && nums[i] == nums[i+1]) {
            i++;
        }
        
        backtrack(nums, current, i+1);
    }

}
