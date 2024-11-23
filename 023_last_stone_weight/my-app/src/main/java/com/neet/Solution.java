package main.java.com.neet;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }

        // Simulate the process of smashing stones
        while (queue.size() > 1) {
            int stone1 = queue.poll(); // Largest stone
            int stone2 = queue.poll(); // Second largest stone
            
            if (stone1 != stone2) {
                queue.add(Math.abs(stone1 - stone2)); // Add the difference back
            }
        }

        // If one stone is left, return it; otherwise, return 0
        return queue.isEmpty() ? 0 : queue.peek();      
    }
}
