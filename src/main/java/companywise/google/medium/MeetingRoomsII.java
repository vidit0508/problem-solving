package src.main.java.companywise.google.medium;

import java.util.Arrays;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int index = 0;

        for (int[] interval : intervals) {
            start[index] = interval[0];
            end[index] = interval[1];
            index++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startIndex = 0;
        int endIndex = 0;
        int rooms = 0;
        int count = 0;

        while (startIndex < intervals.length) {
            if (start[startIndex] < end[endIndex]) {
                count++;
                startIndex++;
                rooms = Math.max(rooms, count);
            } else if (start[startIndex] >= end[endIndex]) {
                count--;
                endIndex++;
            }
        }

        return rooms;
    }
}
