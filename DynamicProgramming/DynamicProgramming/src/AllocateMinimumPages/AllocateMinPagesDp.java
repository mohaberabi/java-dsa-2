package AllocateMinimumPages;

public class AllocateMinPagesDp {

    static int sum(int[] arr, int s, int e) {

        int total = 0;
        for (int i = s; i <= e; i++) {
            total += arr[i];
        }
        return total;
    }

    static int minPages(int[] arr, int k) {

        int n = arr.length;

        int[][] dp = new int[k + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            dp[1][i] = sum(arr, 0, i - 1);
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int res = Integer.MAX_VALUE;

                for (int p = 1; p < j; p++) {
                    res = Math.min(res, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
                }

                dp[i][j] = res;
//                int firstCut = Math.max(dp[i - 1][j - 2], sum(arr, i - 1, j - 1));
//                int secondCut = Math.max(dp[i - 1][j - 1], sum(arr, i, j - 1));
//
//                dp[i][j] = Math.min(firstCut, secondCut);
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};
        int min = minPages(arr, 2);
        System.out.println(min);
    }
}
