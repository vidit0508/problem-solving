package src.main.java.topicwise.arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return nums[getMinIndex(nums, 0, nums.length - 1)];
    }

    private static int getMinIndex(int[] nums, int start, int end) {

        if (start > end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        if ((mid == 0 && nums[mid] < nums[mid + 1])
                || (mid == end && nums[mid] < nums[mid - 1])
                || ((nums[mid] < nums[mid + 1]) && (nums[mid] < nums[mid - 1]))) {
            return mid;
        }
        if (mid < end && nums[end] < nums[mid]) {
            return getMinIndex(nums, mid + 1, end);
        } else {
            return getMinIndex(nums, start, mid - 1);
        }

    }
}
