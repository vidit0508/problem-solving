package src.main.java.topicwise.searchingandsorting;

// O(log(n + m))
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {  {1,3,5,7},
                            {10,11,16,20},
                            {23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int row = 0;
        while (top <= bottom) {
            row = (top + bottom) / 2;
            if (target > matrix[row][matrix[row].length - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                break;
            }
        }

        if (top > bottom) {
            return false;
        }

        int left = 0;
        int right = matrix[row].length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
