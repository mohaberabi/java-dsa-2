public class PalindromePartition {


    static int palindromPartition(String s, int i, int j) {
        if (isPalindrome(s, i, j)) {
            return 0;
        }


        int res = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            res = Math.min(res, palindromPartition(s, i, k) + palindromPartition(s, k + 1, j) + 1);
        }
        return res;
    }

    static boolean isPalindrome(String s, int i, int j) {
        if (s.length() == 1) {
            return true;
        }

        while (i < j) {
            if (s.toCharArray()[i] != s.toCharArray()[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.toCharArray()[i] != s.toCharArray()[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "geek";
        int pal = palindromPartition(s, 0, s.length() - 1); //2
        System.out.println(pal);
    }


    int palindromPartitionOptimized(String s) {
        int n = s.length();


        int[][] dp = new int[n][n];
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; gap++) {
                int j = i + gap;

                if (s.charAt(i) == s.charAt(j) && (isPal[i + 1][j - 1] || gap == 1)) {
                    dp[i][j] = 0;
                    isPal[i][j] = true;
                } else {
                    isPal[i][j] = false;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    int palindromPartitionDp(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];


        for (int gap = 1; gap < n; gap++) {

            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;

                if (isPalindrome(s, i, j)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];

    }
}
