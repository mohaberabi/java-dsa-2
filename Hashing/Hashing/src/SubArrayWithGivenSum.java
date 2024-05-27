import java.util.HashSet;

public class SubArrayWithGivenSum {


    boolean subArrayWithGivenSum(int[] arr, int sum, int n) {
        for (int i = 0; i < n; i++) {


            int curr = 0;
            for (int j = i; j < n; j++) {
                curr += arr[j];
                if (curr == sum) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean subArrayWithGiuenSumOptimal(int[] arr, int sum, int n) {
        HashSet<Integer> set = new HashSet<>();
        int psum = 0;
        for (int x : arr) {
            psum += x;
            if (psum == sum) {
                return true;
            }
            if (set.contains(psum - sum)) {
                return true;
            }
            set.add(psum);
        }
        return false;
    }
}
