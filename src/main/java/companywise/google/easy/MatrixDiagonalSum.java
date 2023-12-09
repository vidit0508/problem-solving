package src.main.java.companywise.google.easy;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;

        for (int i = 0; i < len; i++) {
            sum = sum + mat[i][i] + mat[i][len - i - 1];
        }
        if (len % 2 != 0) {
            sum = sum - mat[len / 2][len / 2];
        }

        return sum;
    }
}
