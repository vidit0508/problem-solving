package src.main.java.top.onefifty.medium.arraystrings;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    private static int hIndex(int[] citations) {
        int len = citations.length;
        int i = 0;

        Arrays.sort(citations);

        while (i < len && citations[len - 1 - i] > i) {
            i++;
        }
        return i;
    }
}
