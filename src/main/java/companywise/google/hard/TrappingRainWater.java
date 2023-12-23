package src.main.java.companywise.google.hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int len = height.length;
        int ans = 0;
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            ans = ans + Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }
}
