package src.main.java.topicwise.searchingandsorting;

import java.util.PriorityQueue;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(getPeak(nums));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a.compareTo(b));
        queue.add(1);
    }

    private static int getPeak(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid > 0 && mid < nums.length - 1)
                    && ((nums[mid] > nums[mid - 1])
                    && (nums[mid] > nums[mid + 1]))) {
                    return mid;
            } else if ((mid == nums.length - 1 && nums[mid - 1] < nums[mid])
                        || (mid == 0 && nums[mid + 1] < nums[mid])) {
                    return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
