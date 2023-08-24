package src.main.java.searchingandsorting;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || (nums[mid] != nums[mid + 1])) {
                    return mid;
                } else {
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

    public static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || (nums[mid] != nums[mid - 1])) {
                    return mid;
                } else {
                    end = mid - 1;
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
