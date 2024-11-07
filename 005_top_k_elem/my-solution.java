import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    /*
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(count.entrySet());
        entryList.sort(Map.Entry.comparingByValue((c1,c2) -> -1 * Integer.compare(c1,c2)));

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = entryList.get(i).getKey();
        }
        return ret;
    }

    /**
     * Time complexity: O(k log n)
     * Memory Complexity: O(n + k)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent_priority_queue(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        var heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    /**
     * Time complexity: O(n)
     * Memory Complexity: O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent_bucket_sort(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            //value 값을 버켓 인덱스로 하고 버켓에 list of key를 담는다. 
            freq[entry.getValue()].add(entry.getKey());
        }

        return res;
    }
}
