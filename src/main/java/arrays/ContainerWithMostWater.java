package src.main.java.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(getMaxWater(height));
    }

    private static int getMaxWater(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
