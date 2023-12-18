package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String st : strs) {
            char[] chArr = st.toCharArray();
            Arrays.sort(chArr);
            String sorted = new String(chArr);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(st);
        }

        return new ArrayList<>(map.values());
    }
}
