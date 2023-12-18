package src.main.java.companywise.google.medium;

// todo need to optimize more
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int noOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    noOfIslands++;
                    createIsland(grid, row, col);
                }
            }
        }
        return noOfIslands;
    }

    private void createIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[row].length
                || grid[row][col] == '0' || grid[row][col] == '2' ) {
            return;
        }

        grid[row][col] = '2';
        createIsland(grid, row + 1, col);
        createIsland(grid, row - 1, col);
        createIsland(grid, row, col + 1);
        createIsland(grid, row, col - 1);
    }

}
