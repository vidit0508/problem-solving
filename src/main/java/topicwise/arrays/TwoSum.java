package src.main.java.topicwise.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int sum = 6;
        int[] res = getTwoSum(arr, sum);
        print(res);
    }

    private static int[] getTwoSum(int[] arr, int sum) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                res[0] = map.get(sum - arr[i]);
                res[1] = i;
            } else {
                map.put(arr[i], i);
            }
        }
        return res;
    }

    private static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
