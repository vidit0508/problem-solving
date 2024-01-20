package src.main.java.top.onefifty.medium;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goalPost) {
                goalPost = i;
            }
        }
        return goalPost == 0;
    }
}
