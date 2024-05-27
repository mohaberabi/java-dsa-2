public class RatInMaze {

    static final int N = 4;
    public static final int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1},
    };

    public static final int[][] sol = new int[N][N];


    static boolean isSafe(int i, int j) {
        return (i < N && j < N && maze[i][j] == 1);
    }

    static boolean solveRec(int i, int j) {
        if (i == N - 1 && j == N - 1) {
            sol[i][j] = 1;
            return true;
        }
        if (isSafe(i, j)) {
            sol[i][j] = 1;
            if (solveRec(i + 1, j)) {
                sol[i][j] = 1;
                return true;
            } else if (solveRec(i, j + 1)) {
                sol[i][j] = 1;
                return true;
            }
            // here we back track
            sol[i][j] = 0;
        }
        return false;
    }

    static boolean solveMaze() {
        if (!solveRec(0, 0)) {
            return false;
        } else {
            printMatrix();
            return true;
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean s = solveMaze();
    }
}
