public class NCR {
    public static int nCrModp(int n, int r) {
        if (r > n) {
            return 0;
        }
        if (r == 0) {
            return 0;
        }


        long dp[][] = new long[n + 1][r + 1];

        long mod = (long) (1e9) + 7;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1 % mod;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, r); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        return (int) dp[n][r];
        // your code here

    }
}
