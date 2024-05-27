import java.util.HashSet;

public class PairWithSum {


    boolean pairHasSumNaive(int[] arr, int sum) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean pairHasSumOptimal(int[] arr, int n, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(sum - x)) {
                return true;
            } else {
                set.add(x);
            }
        }
        return false;
    }
}
