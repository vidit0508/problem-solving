package src.main.java.topicwise.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            String sorted = new String(sChars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new LinkedList<>());
            }
            map.get(sorted).add(s);
        }
        return new LinkedList<>(map.values());
    }
}
