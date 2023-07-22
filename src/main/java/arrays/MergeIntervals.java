package src.main.java.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        print(intervals);
        intervals = merge(intervals);
        print(intervals);
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private static void print(int[][] intervals) {
        System.out.println();
        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1] + ",");
        }
    }
}
