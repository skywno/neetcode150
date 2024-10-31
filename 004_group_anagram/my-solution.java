import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Initialize a HashMap where each key is the sorted version of the string
        // and each value is a list of strings that are anagrams.
        Map<String, List<String>> map = new HashMap<>();
        
        // Loop through each string in the array
        for (String str : strs) {
            // Sort the characters in the string and use the sorted string as a key
            String sortedStr = sortString(str);
            
            // If the key does not exist in the map, initialize a new list for this key
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            // Add the original string to the list corresponding to the sorted key
            map.get(sortedStr).add(str);
        }
        
        // Return all values in the map as a list of lists
        return new ArrayList<>(map.values());
    }   

    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // Loop throught each string in the array
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;   
            }  

            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());

    }
    

    // Helper method to sort the characters in a string
    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
