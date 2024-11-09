package com.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	@DisplayName("Test naive method 1")
	void test1() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring_naive("zxyzxyz"));                     
	}

    @Test
	@DisplayName("Test naive method 2")
	void test2() {
        Solution solution = new Solution();
        assertEquals(1, solution.lengthOfLongestSubstring_naive("xxxx"));                     
	}

	@Test
	@DisplayName("Test sliding window method 1")
	void test3() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring_naive("zxyzxyz"));                     
	}

    @Test
	@DisplayName("Test sliding window method 2")
	void test4() {
        Solution solution = new Solution();
        assertEquals(1, solution.lengthOfLongestSubstring_naive("xxxx"));                     
	}

}