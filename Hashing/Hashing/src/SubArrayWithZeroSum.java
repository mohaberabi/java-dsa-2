import java.util.HashSet;

public class SubArrayWithZeroSum {


    boolean zeroSumSubArray(int[] arr, int n) {


        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean zeroSumSubArrayOptiml(int[] arr, int n) {
        HashSet<Integer> s = new HashSet<>();

        int pSum = 0;
        for (int x : arr) {
            pSum += x;
            if (s.contains(pSum)) {
                return true;
            }

            if (pSum == 0) {
                return true;
            }

            s.add(pSum);
        }
        return false;
    }
}
