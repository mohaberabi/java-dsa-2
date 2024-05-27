public class RateInMazeMultipleJumps {
    public static void solve(int[][] maze, int N) {

        int[][] sol = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }


        boolean ans = solveRec(maze, sol, 0, 0, N);

        if (ans == true) {
            print(sol, N);
        } else {
            System.out.println(-1);
        }

    }

    public static boolean isSafe(int[][] maze, int i, int j, int N) {
        return i < N && j < N && (maze[i][j] > 0);
    }


    public static boolean solveRec(int[][] mat, int[][] sol, int i, int j, int n) {


        if (i == n - 1 && j == n - 1) {
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(mat, i, j, n)) {
            int jumps = mat[i][j];
            sol[i][j] = 1;

            for (int k = 1; k <= jumps; k++) {
                if (solveRec(mat, sol, i, j + k, n)) {
                    return true;
                }
                if (solveRec(mat, sol, i + k, j, n)) {
                    return true;
                }

            }
            sol[i][j] = 0;
        }
        return false;
    }

    public static void print(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
