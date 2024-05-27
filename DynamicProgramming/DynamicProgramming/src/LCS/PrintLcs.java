package LCS;

public class PrintLcs {


    static String lcs(String a, String b) {
        int n = a.length();
        int m = b.length();


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

        int i = n;
        int j = m;

        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {

            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "MOHAB";
        String b = "HAB";

        String lcs = lcs(a, b);
        System.out.println(lcs);
    }
}
