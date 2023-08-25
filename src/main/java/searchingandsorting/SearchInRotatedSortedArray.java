package src.main.java.searchingandsorting;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1)
            return searchTarget(nums, target, 0, nums.length - 1);

        if (nums[pivot] == target)
            return pivot;
        if (nums[0] <= target)
            return searchTarget(nums, target, 0, pivot - 1);
        return searchTarget(nums, target,pivot + 1, nums.length - 1);
    }

    public static int searchTarget(int[] nums, int target, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int findPivot(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        if (mid < end && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if (mid > start && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        }
        if (nums[start] >= nums[mid]) {
            return findPivot(nums, start, mid - 1);
        }
        return findPivot(nums, mid + 1, end);
    }
}
