import Helpers.Helpers;

public class SegragateZerosOnesTwos {


    void segragateZerosOnesTwos(int[] arr, int n) {
        int i = 0;
        int[] temp = new int[n];
        for (int j = 0; j < n; j++) {
            if (arr[j] == 0) {
                temp[i] = arr[j];
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == 1) {
                temp[i] = arr[j];
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == 2) {
                temp[i] = arr[j];
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            arr[j] = temp[j];
        }
    }


    void dutchNationalFlag(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                Helpers.swapArray(arr, low, high);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                Helpers.swapArray(arr, high, mid);
                high--;
            }
        }
    }
}
