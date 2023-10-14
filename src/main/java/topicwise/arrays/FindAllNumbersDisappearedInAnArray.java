package src.main.java.topicwise.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int len = nums.length;
        List<Integer> res = new ArrayList<>();


        while (i < len) {
            int currValue = nums[i];
            if (currValue == -1 || nums[currValue - 1] == -1) {
                i++;
            } else {
                nums[i] = nums[currValue - 1];
                nums[currValue - 1] = -1;
            }
        }

        for (int k = 0; k < len; k++) {
            if (nums[k] > 0) {
                res.add(k + 1);
            }
        }
        return res;
    }
}
