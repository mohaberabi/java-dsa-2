package MatrixChain;

public class MatrixChainDp {


    int matrixChain(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0;
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[j][k] +
                                    arr[i] * arr[j] * arr[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
