package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int compliment = -nums[i] - nums[j];
                    if (seen.containsKey(compliment) && seen.get(compliment) == i) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], compliment);
                        Collections.sort(list);
                        res.add(list);
                    }
                    seen.put(nums[j], i);
                }
            }
        }

        return new ArrayList<>(res);
    }
}
