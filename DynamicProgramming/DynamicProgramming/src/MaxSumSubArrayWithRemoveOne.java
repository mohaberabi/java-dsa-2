public class MaxSumSubArrayWithRemoveOne {

    static int maxSumSubArrayRemoveOneKadanes(int[] arr, int n) {
        int[] fw = new int[n];
        int[] bw = new int[n];

        int maxEndHere = arr[0];
        int maxSoFar = arr[0];
        fw[0] = arr[0];

        // Calculate forward sums and find maximum subarray sum
        for (int i = 1; i < n; i++) {
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
            fw[i] = maxEndHere;
        }

        // Reset maxEndHere for backward calculation
        maxEndHere = arr[n - 1];
        bw[n - 1] = arr[n - 1];

        // Calculate backward sums and find maximum subarray sum
        for (int i = n - 2; i >= 0; i--) {
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            bw[i] = maxEndHere;
        }

        int res = maxSoFar;

        // Find maximum sum by skipping one element
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, fw[i - 1] + bw[i + 1]);
        }

        return res;
    }


    static int maxSumSubArrayRemoveOne(int[] arr, int n) {
        int[] fw = new int[n];
        int[] bw = new int[n];

        for (int i = 0; i < n; i++) {
            fw[i] = sum(arr, i + 1, n);
            if (i == 0) {
                bw[i] = 0;
            } else {
                bw[i] = sum(arr, 0, i + 1) - arr[i];
            }
        }


        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, bw[i] + fw[i]);
        }

        return res;
    }


    static int sum(int[] arr, int i, int j) {
        int s = 0;
        for (int k = i; k < j; k++) {
            s += arr[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, 5};
        int res = maxSumSubArrayRemoveOneKadanes(arr, arr.length);
        System.out.println(res);
    }
}
