public class CountWaysOfCoins {


    int getCoins(int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }


        int pick = getCoins(coins, n, sum - coins[n - 1]);
        int notPick = getCoins(coins, n - 1, sum);
        return pick + notPick;
    }
}
