package src.main.java.arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            maxSum = Math.max(maxEnding, maxSum);
        }
        return maxSum;
    }
}
