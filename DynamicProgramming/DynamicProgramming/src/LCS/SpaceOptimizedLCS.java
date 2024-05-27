package LCS;

public class SpaceOptimizedLCS {


    int lcs(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[2][n + 1];

        // to get privous row and current row
        int bi = 0;

        for (int i = 0; i <= n; i++) {
            bi = 1 & 1;
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[bi][j] = 0;

                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[1 - bi][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }

        }
        return dp[n][m];
    }
}
