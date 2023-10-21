package src.main.java.topicwise.dp;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1], nums[i] + ans[i - 2]);
        }

        return ans[nums.length - 1];
    }

}
