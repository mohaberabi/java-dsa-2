package DikstrasAlgortihmForShortestPath;

public class MinimumCostPath {


    static int minCostPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a 2D array to store the minimum cost at each cell
        int[][] dp = new int[rows][cols];

        // Initialize the first cell with the cost of the starting cell
        dp[0][0] = grid[0][0];

        // Initialize the first row
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // Initialize the first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the dp array
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // Choose the minimum cost path to reach the current cell
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // The bottom-right cell contains the minimum cost to reach there
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] graph = {{9, 4, 9, 9}, {6, 7, 6, 4}, {8, 3, 3, 7}, {7, 4, 9, 10}};

        int min = minCostPath(graph);


        System.out.println(min);

    }
}
