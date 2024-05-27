package MergeSort;

public class MergeTwoSortedArray {


    static int[] mergeTwoSortedArray(int[] a, int[] b, int n, int m) {

        int[] temp = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = b[j];
                j++;
            }
            k++;

        }
        while (i < n) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j < m) {
            temp[k] = b[j];
            j++;
            k++;
        }
        return temp;
    }

    public static void main(String[] args) {

        int[] a = {10, 20, 50};
        int[] b = {5, 50, 50};


        int[] merged = mergeTwoSortedArray(a, b, a.length, b.length);

        for (int x : merged) {
            System.out.print(x + " ");
        }
    }
}
