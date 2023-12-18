package src.main.java.companywise.google.medium;

// todo need to optimize more
public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int start = 0;
            int end = row.length - 1;
            if (row[start] <= target && row[end] >= target) {
                if (doBinarySearch(row, start, end, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doBinarySearch(int[] row, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
