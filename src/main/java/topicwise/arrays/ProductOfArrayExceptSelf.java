package src.main.java.topicwise.arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        print(nums);
        nums = productExceptSelf(nums);
        print(nums);
    }

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = 1;
        int rightProd = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            left[i] = left[i] * rightProd;
            rightProd = rightProd * nums[i];
        }
        return left;
    }

    private static void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
