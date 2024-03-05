package src.main.java.companywise.expedia;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {200, 3, 140, 20, 10};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int max1 = robHouses(nums, 0, nums.length - 2);
        int max2 = robHouses(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public static int robHouses(int[] nums, int start, int end) {
        int[] ans = new int[end - start + 1];
        int i = 0;
        ans[i++] = nums[start];
        ans[i++] = Math.max(nums[start + 1], nums[start]);
        for (int r = start + 2; r <= end; r++) {
            ans[i] = Math.max(ans[i - 1], nums[r] + ans[i - 2]);
            i++;
        }
        return ans[ans.length - 1];
    }
}
