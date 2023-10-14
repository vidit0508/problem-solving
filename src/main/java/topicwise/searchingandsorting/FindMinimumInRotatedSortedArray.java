package src.main.java.topicwise.searchingandsorting;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(getSmalletElement(nums));
    }

    private static int getSmalletElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
