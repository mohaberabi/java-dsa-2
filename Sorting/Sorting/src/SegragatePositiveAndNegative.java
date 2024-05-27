import Helpers.Helpers;

public class SegragatePositiveAndNegative {


    void segrageEvenOdd(int[] arr, int n) {
        int i = -1;
        int j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);

            do {
                j--;
            } while (arr[j] >= 0);

            if (i >= j) {
                return;
            }
            Helpers.swapArray(arr, i, j);
        }
    }
}

