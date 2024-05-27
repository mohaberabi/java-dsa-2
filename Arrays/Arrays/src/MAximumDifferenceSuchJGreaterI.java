public class MAximumDifferenceSuchJGreaterI {


    static int maxDiff(int[] arr, int n) {
        int res = arr[1] - arr[0];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }
        return res;

    }


    static int maxDiffOptimal(int[] arr, int n) {
        int res = arr[1] - arr[0];

        int minVal = arr[0];

        for (int i = 1; i < n; i++) {
            res = Math.max(res, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }
        return res;
    }

}
