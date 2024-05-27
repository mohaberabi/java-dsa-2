package LIS;

public class LongestIncreasingSubSequence {


    static int lis(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int lis = 0;

        for (int i = 0; i < n; i++) {
            lis = Math.max(dp[i], lis);
        }
        return lis;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int l = lis(arr);
        System.out.println(l);
    }
}
