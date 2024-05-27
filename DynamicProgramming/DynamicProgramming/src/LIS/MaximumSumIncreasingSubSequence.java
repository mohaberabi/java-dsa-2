package LIS;

public class MaximumSumIncreasingSubSequence {


    static int maximumSumIncreasingSubSequence(int[] arr) {
        int n = arr.length;

        int[] maxSum = new int[n];
        for (int i = 0; i < n; i++) {
            maxSum[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxSum[i] = Math.max(maxSum[i], arr[i] + maxSum[j]);
                }
            }
        }

        int res = maxSum[0];

        for (int i = 1; i < n; i++) {
            res = Math.max(maxSum[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 20, 4, 6, 7, 30};
        int res = maximumSumIncreasingSubSequence(arr);
        System.out.println(res);
    }
}
