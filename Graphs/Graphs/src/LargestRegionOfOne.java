public class LargestRegionOfOne {


    static int largestRegionOfOne(int[][] grid) {


        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxRegionSize = 0;

        // Iterate through the entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // Found a cell with 1, start DFS to find the region size
                    int regionSize = dfs(grid, i, j);
                    maxRegionSize = Math.max(maxRegionSize, regionSize);
                }
            }
        }

        return maxRegionSize;
    }

    static int dfs(int[][] grid, int row, int col) {


// Base cases
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        // Mark the current cell as visited
        grid[row][col] = 0;

        // Explore 8 directions (horizontally, vertically, diagonally)
        int regionSize = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    regionSize += dfs(grid, row + i, col + j);
                }
            }
        }

        return regionSize;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int res = largestRegionOfOne(grid);
        System.out.println(res);
    }
}
