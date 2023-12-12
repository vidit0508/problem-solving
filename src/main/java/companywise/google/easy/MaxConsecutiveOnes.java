package src.main.java.companywise.google.easy;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        int currCount = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currCount++;
                maxCount = Math.max(maxCount, currCount);
            } else {
                currCount = 0;
            }
        }
        return maxCount;
    }
}
