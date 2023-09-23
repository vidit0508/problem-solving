package src.main.java.arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
        printMaximumSumSubarray(nums);
    }

    // by this way we can print sub array with maximum sum
    private static void printMaximumSumSubarray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        int startIndex = 0;
        int endIndex = 0;
        int maxStartIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i] + currSum) {
                currSum = nums[i];
                startIndex = i;
            } else if (nums[i] < nums[i] + currSum) {
                currSum = currSum + nums[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                endIndex = i;
                maxStartIndex = startIndex;
            }
        }

        for (int i = maxStartIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    private static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            maxSum = Math.max(maxEnding, maxSum);
        }
        return maxSum;
    }
}
