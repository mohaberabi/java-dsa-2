public class CanBeDividedIntoTwo {


    boolean canPartitionToTwo(int[] arr, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // case if it's odd
        if (sum % 2 == 1) {
            return false;
        }

        boolean[][] dp = new boolean[2][sum + 1];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i % 2][j] = true;
                } else if (i == 0) {
                    dp[i % 2][j] = false;

                } else if (arr[i - 1] <= j)
                    dp[i % 2][j] = dp[(i + 1) % 2][j - arr[i - 1]] ||
                            dp[(i + 1) % 2][j];
                else
                    dp[i % 2][j] = dp[(i + 1) % 2][j];
            }
        }
        return dp[n % 2][sum / 2];

    }

}
