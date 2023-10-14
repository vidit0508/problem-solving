package src.main.java.topicwise.arrays;

public class RotateArrayRight {

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        print(nums);
        rotateRight(nums, k);
        print(nums);
    }

    private static void rotateRight(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private static void rotate(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private static void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
