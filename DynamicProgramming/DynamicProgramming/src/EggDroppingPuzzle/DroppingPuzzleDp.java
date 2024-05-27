package EggDroppingPuzzle;

public class DroppingPuzzleDp {


    static int minTrials(int floors, int eggs) {

        int[][] dp = new int[floors + 1][eggs + 1];

        for (int i = 1; i <= eggs; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= floors; i++) {
            dp[i][1] = i;
        }


        for (int i = 2; i <= floors; i++) {
            for (int j = 2; j <= eggs; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                }
            }
        }

        return dp[floors][eggs];
    }

    public static void main(String[] args) {

        int min = minTrials(3, 2);
        System.out.println(min);
    }
}
