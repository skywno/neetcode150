import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue((c1,c2) -> -1 * Integer.compare(c1,c2)));
        System.out.println(entryList);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = entryList.get(i).getKey();
        }
        return ret;
    }
}
