public class SudokuSolver {

    public static final int N = 4;

    public static final int[][] sudoku = {
            {1, 0, 3, 4},
            {0, 0, 2, 1},
            {0, 1, 4, 2},
            {2, 4, 1, 0}
    };

    static boolean isSafe(int row, int col, int x, int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            if (grid[row][i] == x || grid[i][col] == x) {
                return false;
            }

        }

        int sqrt = (int) Math.sqrt(n);
        int rowStart = (int) row - row % sqrt;
        int colStart = (int) col - col % sqrt;


        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (grid[i][j] == x) {
                    return false;
                }
            }
        }
        return true;
    }

    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        int n = grid.length;
        int i = 0;
        int j = 0;
        boolean found = false;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    found = true;
                    break;

                }
            }
            if (found) {
                break;
            }
        }


        if (i == n && j == n) {
            return true;
        }
        for (int x = 1; x <= n; x++) {
            if (isSafe(i, j, x, n, grid)) {
                grid[i][j] = x;
                if (SolveSudoku(grid)) {
                    return true;
                }
                grid[i][j] = 0;
            }

        }
        return false;

        // add your code here
    }

    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }

        }
        // add your code here
    }

    public static void main(String[] args) {

    }
}
