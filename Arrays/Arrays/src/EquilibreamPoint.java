public class EquilibreamPoint {


    int equilibramPoint(int[] arr, int n) {
        int right = 0;
        for (int i = 0; i < n; i++) {
            right += arr[i];
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            right -= arr[i];
            if (left == right) {
                return i;
            }
            left += arr[i];
        }
        return -1;
    }
}
