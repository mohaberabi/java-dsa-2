package EditDistance;

public class EditDistanceDp {


    static int editDistance(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int added = dp[i][j - 1];
                    int deleted = dp[i - 1][j];
                    int replaced = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(Math.min(added, deleted), replaced);
                }
            }
        }


        return dp[n][m];
    }

    public static void main(String[] args) {


        String a = "SATURDAY";
        String b = "SUNDAY";
        int ed = editDistance(a, b);
        System.out.println(ed);
    }
}
