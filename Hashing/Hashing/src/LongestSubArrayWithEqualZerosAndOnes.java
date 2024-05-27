import java.util.HashMap;

public class LongestSubArrayWithEqualZerosAndOnes {


    int longestSubEqualZerosOnes(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    res = Math.max(res, ones);
                }
            }
        }
        return res;
    }

    int longestSubArrayWithZerosAndOnes(int[] arr, int n) {


        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int res = longestSubArrayWithSumOptimal(arr, n, 0);
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
