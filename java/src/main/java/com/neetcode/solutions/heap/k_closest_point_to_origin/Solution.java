package com.neetcode.solutions.heap.k_closest_point_to_origin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create max heap (furthest points at top) using custom comparator
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> 
            (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])
        );
        
        // Maintain heap of k closest points
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();  // Remove furthest point if we exceed k
            }
        }
        
        // Convert heap to result array
        int[][] result = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }

    //sort
    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }


    //TODO: QuickSelect Implementation
}
