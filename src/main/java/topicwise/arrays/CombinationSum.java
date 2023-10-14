package src.main.java.topicwise.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        getSums(candidates, target, 0, 0, list);
        return res;
    }

    public static void getSums(int[] candidates, int target, int index, int currSum, List<Integer> list) {
        // bounding condition
        if (currSum > target) {
            return;
        }

        // base case
        if (index == candidates.length) {
            if (currSum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        currSum = currSum + candidates[index];
        list.add(candidates[index]);
        getSums(candidates, target, index, currSum, list);
        currSum = currSum - candidates[index];
        list.remove(list.size() - 1);

        getSums(candidates, target, index + 1, currSum, list);
    }
}
