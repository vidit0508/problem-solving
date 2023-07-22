package src.main.java.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < len; end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            maxLen = Math.max(maxLen, (end - start) + 1);
            map.put(ch, end);
        }
        return maxLen;
    }
}
