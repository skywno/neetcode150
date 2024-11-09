package com.neetcode;

import java.util.HashMap;

public class Solution {

    //BruteForce
    public int characterReplacement(String s, int k) {
        int gMax = 0; //globalMaxLength
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int lMax = 0; //localMaxLength

            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                lMax = Math.max(lMax, count.get(s.charAt(j)));
                if ((j - i + 1) - lMax <= k) {
                    gMax = Math.max(gMax, j - i + 1);
                }
            }
        } 
        return gMax;   
    }

    //Sliding window
    public int characterReplacement2(String s, int k) {
        int gMax = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), 1 + count.getOrDefault(s.charAt(r), 0));
            int lMax = count.entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .orElseThrow()
                .getValue();
            while ((r - l + 1) - lMax > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            gMax = Math.max(gMax, r - l + 1);
        }
        return gMax;
    }

}
