public class KadanesAlgorithm {


    static int maxSumSubArray(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i], arr[i] + max);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 2};
        int maxSum = maxSumSubArray(nums);
        System.out.println("Maximum subarray sum is: " + maxSum);
    }
}
