import java.util.ArrayList;

public class SubArrayWithSum {


    boolean hasSum(int[] arr, int n, int sum) {
        int s = 0;
        int curr = 0;
        for (int e = 0; e < n; e++) {
            curr += arr[e];
            while (sum < curr) {
                curr -= arr[s];
                s++;
            }
            if (sum == curr) {
                return true;
            }
        }
        return false;
    }

    boolean hasSumReturnIndex(int[] arr, int n, int sum, ArrayList<Integer> ar) {
        int s = 0;
        int curr = 0;
        for (int e = 0; e < n; e++) {
            curr += arr[e];
            while (sum < curr) {
                curr -= arr[s];
                s++;
            }
            if (sum == curr) {
                ar.add(s);
                ar.add(e);
                return true;
            }
        }
        return false;
    }
}
