import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsInGrid {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // Mark the current cell as visited

        // Explore all 8 directions
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
        dfs(grid, row - 1, col - 1); // Diagonal Up-Left
        dfs(grid, row - 1, col + 1); // Diagonal Up-Right
        dfs(grid, row + 1, col - 1); // Diagonal Down-Left
        dfs(grid, row + 1, col + 1); // Diagonal Down-Right
    }
}
