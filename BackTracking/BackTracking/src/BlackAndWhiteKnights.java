public class BlackAndWhiteKnights {


    static final int N = 2;
    static final int[][] board = new int[N][N];
    static int count = 0;

    private static boolean isSafe(int row, int col) {
        int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && board[newRow][newCol] == 1) {
                return false; // If there is already a knight in an attacking position
            }
        }

        return true;
    }

    static boolean solveRec(int col) {
        if (col == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {

                board[i][col] = 1;
                count++;

                if (solveRec(col + 1)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void printMatrix() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solve() {
        if (!solveRec(0)) {
            return false;
        } else {
            printMatrix();
            return true;
        }
    }

    public static void main(String[] args) {

        boolean res = solve();
        System.out.println(count);

    }
}
