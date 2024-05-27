import java.util.Arrays;

public class MinimumJumpsToReachEnd {


    static int minJumpsRecusrive(int[] arr, int n) {
        if (n == 1) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 2; i++) {

            if (i + arr[i] >= n - 1) {
                int subRes = minJumpsRecusrive(arr, i + 1);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(subRes + 1, res);
                }
            }
        }
        return res;
    }


    static int minJumpsDp(int[] arr) {


        int n = arr.length;

        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 7};
        int min = minJumpsDp(arr);
        System.out.println(min);
    }
}
