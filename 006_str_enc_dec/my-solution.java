import java.util.ArrayList;
import java.util.List;

class Solution {

    public String encode(List<String> strs) {
        StringBuilder ret = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            ret.append(length).append('#').append(str);
        }       
        return ret.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> ret = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != '#') {
                cur.append(str.charAt(i));
                i++;
            }
            // Size
            int size = Integer.parseInt(cur.toString());
            System.out.println(size);
            System.out.println(str.charAt(i));
            i++;
            // Extract the substring
            String s = str.substring(i, i + size);
            System.out.println(s);
            ret.add(s);
            
            // Move i to the end of the current substring
            i += size;
        }
        return ret;
    }
}
