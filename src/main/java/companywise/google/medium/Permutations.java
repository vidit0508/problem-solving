package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, nums);
        return res;
    }

    private void backtrack(List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }


        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, res, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
