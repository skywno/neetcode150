package com.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    //given ABBB
    //output 4
        
    @Test
    public void test1() {
        Solution solution = new Solution();
        int res = solution.characterReplacement("XYYX", 2);
        assertEquals(4, res);
    }


    @Test
    public void test2() {
        Solution solution = new Solution();
        int res = solution.characterReplacement("AAABABB", 1);
        assertEquals(5  , res);
    }
}
