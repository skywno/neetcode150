package com.neetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring_naive(String s) {
        int maxLength = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();
        int l = 0; int r = 0;
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                l++;
                r = l;
                len = 0;
                set.clear();
            } else {
                maxLength = Math.max(maxLength, ++len);
                set.add(s.charAt(r));
                r++;
            }
        }

        return maxLength;
    } 

    public int lengthOfLongestSubstring_sliding_window(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // Remove characters from the left until there are no duplicates
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
    }
}
