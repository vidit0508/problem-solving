package src.main.java.top.onefifty.medium.arraystrings;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int jumpCount = 0;

        while (end < nums.length - 1) {
            int farthest = 0;
            for (int i = start; i <= end; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            start = end + 1;
            end = farthest;
            jumpCount++;
        }
        return jumpCount;
    }
}
