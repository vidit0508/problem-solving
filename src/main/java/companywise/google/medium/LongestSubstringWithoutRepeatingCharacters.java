package src.main.java.companywise.google.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < len; end++) {
            Character ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            maxLen = Math.max(maxLen, (end - start) + 1);
            map.put(ch, end);
        }

        return maxLen;
    }
}
