import java.util.Arrays;

public class MinimumCoinsToGetValue {


    int minCoins(int[] arr, int sum) {
        int n = arr.length;

        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i <= sum; i++) {

            for (int k : arr) {
                if (k <= i) {
                    int subRes = dp[i - arr[i]];
                    if (subRes != max) {
                        dp[i] = Math.min(dp[i], subRes + 1);
                    }
                }
            }
        }
        return dp[sum];
    }
}
