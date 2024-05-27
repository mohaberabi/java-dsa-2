public class MaximumCutsOfRope {


    int maxCutsRec(int n, int a, int b, int c) {


        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        int fromA = maxCutsRec(n - a, a, b, c);
        int fromB = maxCutsRec(n - b, a, b, c);
        int fromC = maxCutsRec(n - c, a, b, c);

        int res = Math.max(Math.max(fromA, fromB), fromC);

        if (res == -1) {
            return res;
        } else {
            return res + 1;
        }

    }

    int maxCuts(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            // this for not getting -ve index *3 in the 3 cases
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }
            if (dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n];
    }
}
