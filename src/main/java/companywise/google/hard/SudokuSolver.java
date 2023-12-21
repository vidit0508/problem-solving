package src.main.java.companywise.google.hard;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int row = 0;
        int col = 0;
        int len = board.length;

        rowLoop:
        for (row = 0; row < len; row++) {
            for (col = 0; col < len; col++) {
                if (board[row][col] == '.') {
                    break rowLoop;
                }
            }
        }

        if (row == len && col == len) {
            return true;
        }

        for (int i = 1; i <= len; i++) {
            if (isSafeToInsert(board, row, col, i)) {
                board[row][col] = (char) (i + '0');
                if (solve(board)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafeToInsert(char[][] board, int row, int col, int value) {

        // check this value already exist in row
        for (int i = 0; i <= 8; i++) {
            if (Character.getNumericValue(board[row][i]) == value) {
                return false;
            }
        }

        // check this value already exist in column
        for (int i = 0; i <= 8; i++) {
            if (Character.getNumericValue(board[i][col]) == value) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(board[i + startRow][j + startCol]) == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
