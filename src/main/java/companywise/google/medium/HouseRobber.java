package src.main.java.companywise.google.medium;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 2], arr[i - 1]);
        }
        return arr[nums.length - 1];
    }
}
