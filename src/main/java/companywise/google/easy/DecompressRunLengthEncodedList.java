package src.main.java.companywise.google.easy;

import java.util.Arrays;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int newSize = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            newSize = newSize + nums[i];
        }

        int[] arr = new int[newSize];
        int startIndex = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            Arrays.fill(arr, startIndex, startIndex + nums[i], nums[i + 1]);
            startIndex = startIndex + nums[i];
        }

        return arr;
    }
}
