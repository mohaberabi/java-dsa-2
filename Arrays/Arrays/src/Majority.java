public class Majority {

    int indexOfMajorityElement(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }

            }
            if (count > n / 2) {
                return i;
            }
        }
        return -1;
    }


    int majorityOptimal(int[] arr, int n) {
        int res = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[res]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[res]) {
                count++;
            }
        }
        if (count <= n / 2) {
            return -1;
        }
        return count;
    }
}
