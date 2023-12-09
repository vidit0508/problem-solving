package src.main.java.companywise.google.easy;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        // in this map key = index value, value = number of time that index value occured
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i : nums) {
            ans = ans + map.getOrDefault(i, 0);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return ans;
    }

}
