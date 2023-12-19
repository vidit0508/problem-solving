package src.main.java.companywise.google.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        int index = 0;
        int twoIndex = nums.length - 1;
        int zeroIndex = 0;

        while (index <= twoIndex) {
            if (nums[index] == 0) {
                nums[index] = nums[zeroIndex];
                nums[zeroIndex] = 0;
                zeroIndex++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex--;
                index--;
            }
            index++;
        }
    }
}
