package src.main.java.topicwise.graph;

public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int noOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    noOfIslands++;
                    checkForIsland(grid, row, col);
                }
            }
        }
        return noOfIslands;
    }

    private static void checkForIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0
                || col >= grid[0].length
                || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        checkForIsland(grid, row + 1, col);
        checkForIsland(grid, row - 1, col);
        checkForIsland(grid, row, col - 1);
        checkForIsland(grid, row, col + 1);
    }
}
