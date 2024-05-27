public class MAximumSumSubArray {

    static int maxSumKadanesAlgorithm(int[] arr, int n) {
        int maxEnd = arr[0];
        int res = arr[0];


        for (int i = 1; i < n; i++) {
            maxEnd = Math.max(maxEnd + arr[i], arr[i]);
            res = Math.max(res, maxEnd);
        }

        return res;
    }


    static int maxSumSubArrayNaive(int[] arr, int n) {
        int res = arr[0];

        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i + 1; j < n; j++) {
                curr += arr[j];
                res = Math.max(res, curr);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 3};
        int res = maxSumKadanesAlgorithm(arr, arr.length);
        System.out.println(res);
    }
}
