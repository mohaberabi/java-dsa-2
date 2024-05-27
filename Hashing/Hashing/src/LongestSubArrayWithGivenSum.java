import java.util.HashMap;

public class LongestSubArrayWithGivenSum {


    int longestSubArrayWithGivenSum(int[] arr, int sum, int n) {

        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr += arr[j];
                if (curr == sum) {
                    res = Math.max(res, (j - i) + 1);
                }
            }
        }
        return res;
    }


    int longestSubArrayWithSumOptimal(int[] arr, int n, int sum) {
        int psum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            psum += arr[i];
            if (psum == sum) {
                res = i + 1;
            }
            if (!map.containsKey(psum)) {
                map.put(psum, i);
            }
            if (map.containsKey(psum - sum)) {
                res = Math.max(res, i - map.get(psum - sum));
            }
        }
        return res;
    }
}
