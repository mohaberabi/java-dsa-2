package LCS;

public class lcsMemoization {

    static int lcs(int memo[][], String a, String b, int n, int m) {

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (m == 0 || n == 0) {
            memo[n][m] = 0;
        } else {
            if (a.charAt(n - 1) == b.charAt(m - 1)) {
                int match = lcs(memo, a, b, n - 1, m - 1);
                memo[n][m] = 1 + match;
            } else {
                int first = lcs(memo, a, b, n - 1, m);
                int second = lcs(memo, a, b, n, m - 1);
                memo[n][m] = Math.max(first, second);
            }
        }

        return memo[n][m];
    }

    public static void main(String[] args) {
        String str1 = "AXYZ";
        String str2 = "BAZ";
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        int l = lcs(memo, str1, str2, str1.length(), str2.length());
        System.out.println(l);
    }
}
