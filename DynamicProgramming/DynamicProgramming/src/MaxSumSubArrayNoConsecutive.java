public class MaxSumSubArrayNoConsecutive {


    static int maxSumRecursive(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        } else if (n == 2) {
            return Math.max(arr[0], arr[1]);
        } else {
            int notTaken = maxSumRecursive(arr, n - 1);
            int taken = maxSumRecursive(arr, n - 2) + arr[n - 1];
            return Math.max(notTaken, taken);
        }
    }


    static int maxSumDpSpaceOptimized(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        int prevPrev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;

        for (int i = 3; i <= n; i++) {
            res = Math.max(prev, prevPrev + arr[i - 1]);
            prevPrev = prev;
            prev = res;
        }
        return res;
    }

    static int maxSumDp(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        int max = maxSumDp(arr);
        System.out.println(max);
    }
}
