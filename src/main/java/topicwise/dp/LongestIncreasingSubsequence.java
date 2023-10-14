package src.main.java.topicwise.dp;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(getLengthOfLongestIncreasingSubsequence(nums));
    }

    private static int getLengthOfLongestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int tailCurr = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[tailCurr - 1]) {
                tail[tailCurr] = nums[i];
                tailCurr++;
            } else {
                int ceilIndex = getCeilIndex(tail, 0, tailCurr - 1, nums[i]);
                tail[ceilIndex] = nums[i];
            }
        }
        return tailCurr;
    }

    private static int getCeilIndex(int[] tail, int left, int right, int num) {
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (tail[middle] < num) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }
}
