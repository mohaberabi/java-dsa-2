package LCS;

public class LongestPalindromicString {


    static int longestPalindromeSubSequence(String a, int n) {


        char[] bArr = a.toCharArray();

        int left = 0;
        int right = n - 1;

        while (left < right) {

            char temp = bArr[left];
            bArr[left] = bArr[right];

            bArr[right] = temp;
            left++;
            right--;
        }

        String rev = new String(bArr);

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }


        return dp[n][n];

    }

    public static void main(String[] args) {
        String a = "GEEKSFORGEEKS";
        int l = longestPalindromeSubSequence(a, a.length());
        System.out.println(l);
    }

}
