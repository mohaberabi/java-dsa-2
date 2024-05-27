public class MAxConsecuitiveOnes {

    int maxOnesNaive(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {

                if (arr[j] == 1) {
                    curr++;
                } else {
                    break;
                    
                }
            }

            res = Math.max(curr, res);
        }

        return res;
    }


    int maxOnesOptimal(int[] arr, int n) {
        int res = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                curr = 0;
            } else {
                curr++;
                res = Math.max(curr, res);
            }
        }
        return res;
    }
}
