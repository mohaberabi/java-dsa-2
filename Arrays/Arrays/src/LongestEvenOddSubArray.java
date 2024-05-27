public class LongestEvenOddSubArray {


    int longestEvenOddSubArrayNaive(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i + 1; j < n; j++) {

                if (isAlternate(arr, j, j - 1)) {
                    curr++;
                } else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }


    int longestEvenOddOptimal(int[] arr, int n) {
        int res = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (isAlternate(arr, i, i - 1)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }

    boolean isAlternate(int[] arr, int i, int j) {
        return (arr[i] % 2 == 0 && arr[j] % 2 != 0) || (arr[j] % 2 == 0 && arr[i] % 2 != 0);
    }
}
