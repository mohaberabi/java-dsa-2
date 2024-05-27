package ZeroOneKnapSack;

public class KnapSackDp {


    static int knapSack(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];


        // all values are initialized as 0 , so no need to fill first col and first row with zeros

        for (int item = 1; item <= n; item++) {
            for (int cap = 1; cap <= W; cap++) {
                if (wt[item - 1] > cap) {
                    dp[item][cap] = dp[item - 1][cap];
                } else {
                    int include = val[item - 1] + dp[item - 1][cap - wt[item - 1]];
                    int notInclude = dp[item - 1][cap];
                    dp[item][cap] = Math.max(include, notInclude);

                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        int W = 10;

        int knap = knapSack(wt, val, W, wt.length);
        System.out.println(knap);
    }
}
