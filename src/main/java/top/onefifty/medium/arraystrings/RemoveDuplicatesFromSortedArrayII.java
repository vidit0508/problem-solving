package src.main.java.top.onefifty.medium.arraystrings;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        printArray(nums);
        System.out.println(removeDuplicates(nums));
        printArray(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length - 1;

        while (right <= len) {
            int count = 1;
            while (right + 1 <= len && nums[right] == nums[right + 1]) {
                count++;
                right++;
            }

            count = Math.min(count, 2);

            for (int i = 0; i < count; i++) {
                nums[left] = nums[right];
                left++;
            }

            right++;
        }
        return left;
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num  + " ");
        }
    }
}
