package LCS;

public class LcsTabulation {


    static int lcs(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];

    }


    public static void main(String[] args) {

        int l = lcs("mohab", "mo", 5, 2);
        System.out.println(l);
    }
}
