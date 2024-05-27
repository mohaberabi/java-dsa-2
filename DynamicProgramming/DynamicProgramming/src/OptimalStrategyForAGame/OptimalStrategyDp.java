package OptimalStrategyForAGame;

public class OptimalStrategyDp {


    int strategy(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }
        for (int gap = 3; gap < n; gap += 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = gap + i;
                int heFirst = Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                int heSecond = Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                dp[i][j] = Math.max(arr[i] + heFirst, arr[j] + heSecond);
            }
        }
        return dp[0][n - 1];
    }

}
