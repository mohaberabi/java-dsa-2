import java.util.Arrays;

public class MinimumDiff {


    int minimumDiffOfArray(int[] arr, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                res = Math.min(res, Math.abs(arr[i] - arr[j]));
            }
        }
        return res;
    }


    static int minDiffrenceOptimal(int[] arr, int n) {
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, Math.abs(arr[i] - arr[i - 1]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int res = minDiffrenceOptimal(arr, arr.length);
        System.out.println(res);
    }
}
