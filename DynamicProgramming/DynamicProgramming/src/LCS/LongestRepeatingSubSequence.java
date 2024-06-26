package LCS;

public class LongestRepeatingSubSequence {

    static int longestRepeatingSubSequence(String a, int n) {
        String b = a;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String a = "AABB";
        int l = longestRepeatingSubSequence(a, a.length());
        System.out.println(l);
    }
}
