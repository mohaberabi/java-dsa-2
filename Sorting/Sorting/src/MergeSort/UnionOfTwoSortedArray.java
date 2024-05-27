package MergeSort;

public class UnionOfTwoSortedArray {


    void printUionOfTwoSortedArray(int[] a, int[] b, int n, int m) {
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;

            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;

            }

            if (a[i] < b[j]) {
                i++;
                System.out.println(a[i] + " ");
            }
            if (b[j] < a[i]) {
                j++;
                System.out.println(b[j] + " ");
            }
        }
        while (i < n) {
            if (i > 0 && a[i] != a[i - 1]) {
                i++;
                System.out.println(a[i] + " ");
            }
        }
        while (j < m) {
            if (j > 0 && b[j] != b[j - 1]) {
                j++;
                System.out.println(b[j] + " ");
            }
        }
    }
}
