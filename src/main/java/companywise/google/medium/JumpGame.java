package src.main.java.companywise.google.medium;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goalPost) {
                goalPost = i;
            }
        }
        return goalPost == 0;
    }
}
