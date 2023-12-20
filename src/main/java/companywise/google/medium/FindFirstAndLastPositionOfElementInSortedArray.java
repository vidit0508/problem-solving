package src.main.java.companywise.google.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = find(nums, target, false);
        return new int[]{first, last};
    }

    public int find(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
