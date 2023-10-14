package src.main.java.topicwise.greedy;

import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.print(findPlatform(arr, dep, n));
    }

    public static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int aIndex = 0;
        int dIndex = 0;
        int count = 0;
        int max = 0;

        while (aIndex < n) {
            if (arr[aIndex] <= dep[dIndex]) {
                count++;
                max = Math.max(count, max);
                aIndex++;
            } else if (arr[aIndex] > dep[dIndex]) {
                dIndex++;
                count--;
            }
        }
        return max;
    }
}
