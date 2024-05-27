public class MaxCirculerSumSubArray {


    int maxCirculer(int[] arr, int n) {


        int res = arr[0];

        for (int i = 0; i < n; i++) {
            int currMax = arr[i];
            int currSum = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                currSum += arr[index];
                currMax = Math.max(currSum, currMax);
            }
            res = Math.max(res, currSum);

        }
        return res;
    }


    int kadanes(int[] arr, int n) {

        int res = arr[0];
        int maxEnd = arr[0];

        for (int i = 1; i < n; i++) {
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);
            res = Math.max(maxEnd, res);
        }
        return res;
    }


    int maxCurculerSumSubArrayOptimal(int[] arr, int n) {
        int normalMaxSum = kadanes(arr, n);
        if (normalMaxSum < 0) {
            return normalMaxSum;
        }
        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += arr[i];
            arr[i] = -arr[i];
        }
        int maxCirculer = arraySum + kadanes(arr, n);
        return Math.max(maxCirculer, maxCirculer);
    }
    
}
