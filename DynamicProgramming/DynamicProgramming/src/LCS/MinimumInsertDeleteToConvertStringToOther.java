package LCS;

public class MinimumInsertDeleteToConvertStringToOther {


    static int lcs(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    static int minimumOperationsToConvert(String a, String b) {
        int lcs = lcs(a, b, a.length(), b.length());
        return a.length() - lcs;
    }

    public static void main(String[] args) {
        String a = "mohab";
        String b = "hab";
        int ans = minimumOperationsToConvert(a, b);
        System.out.println(ans); // 2
    }
}
