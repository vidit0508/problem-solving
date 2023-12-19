package src.main.java.companywise.google.medium;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int res = 1;
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}
