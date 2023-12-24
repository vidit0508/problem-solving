package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean intervalInserted = false;
        List<int[]> list = new ArrayList<>();

        // 1. we wil add the interval
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                list.add(newInterval);
                intervalInserted = true;
            }
            list.add(intervals[i]);
        }

        if (!intervalInserted) {
            list.add(newInterval);
        }

        // 2. we wil merge all the interval
        LinkedList<int[]> merged = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (merged.isEmpty() || merged.getLast()[1] < list.get(i)[0]) {
                merged.add(list.get(i));
            } else if (merged.getLast()[1] >= list.get(i)[0]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], list.get(i)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
