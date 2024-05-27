import java.util.LinkedList;
import java.util.Queue;

public class KnightMinSteps {


    static class Point {
        int x;
        int y;

        int dist;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.dist = d;
        }


    }

    public static int minStepsByKnight(int rowStart, int colStart, int targetRow, int targetCol, int n) {
        int[][] moves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};


        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        q.add(new Point(rowStart, colStart, 0));
        visited[rowStart][colStart] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.x == targetRow && curr.y == targetCol) {
                return curr.dist;
            }

            for (int[] move : moves) {
                int newX = curr.x + move[0];
                int newY = curr.y + move[0];
                if (isSafe(n, newX, newY) && !visited[newX][newY]) {

                    q.add(new Point(newX, newY, curr.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }


    //backtracking
    static boolean isSafe(int N, int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N;
    }

    public static void main(String[] args) {
        int res = minStepsByKnight(4, 5, 1, 1, 6);
        System.out.println(res);
    }
}
