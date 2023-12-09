package src.main.java.companywise.google.easy;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int start = 0;
            int end = row.length -1;

            while (start < end) {
                int temp = row[start];
                row[start] = row[end] == 1 ? 0 : 1;
                row[end] = temp == 1 ? 0 : 1;
                start++;
                end--;
            }
            if (start == end) {
                row[start] = row[start] == 1 ? 0 : 1;
            }
        }
        return image;
    }
}
