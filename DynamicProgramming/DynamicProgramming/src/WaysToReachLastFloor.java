public class WaysToReachLastFloor {

    int ways(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }


        long[] dp = new long[n + 1];
        long mod = (long) (1e9) + 7;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
        }


        return (int) dp[n];
    }
}
