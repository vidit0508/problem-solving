package src.main.java.companywise.google.easy;

public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

}
