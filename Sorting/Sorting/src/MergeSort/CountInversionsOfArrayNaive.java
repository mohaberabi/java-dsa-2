package MergeSort;

public class CountInversionsOfArrayNaive {


    int inversions(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    res++;
                }
            }
        }
        return res;
    }


    static int countInversions(int[] arr, int low, int high) {
        int res = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            res += countInversions(arr, low, mid);
            res += countInversions(arr, mid + 1, high);
            res += countAndMerge(arr, low, mid, high);

        }
        return res;
    }

    static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        int res = 0;

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }


        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                res += (n1 - i);
            }
            k++;
        }


        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 11, 3, 6, 9, 13};
        int inv = countInversions(arr, 0, arr.length - 1);
        System.out.println(inv);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
