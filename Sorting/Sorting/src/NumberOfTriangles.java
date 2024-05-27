public class NumberOfTriangles {


    static int numberOfDifferentTriangles(int[] arr, int n) {


        if (n <= 2) {
            return -1;
        }

        if (n == 3) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[i] != arr[j] && arr[j] != arr[j + 1]) {
                    res++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {6, 4, 9, 7, 8};
        int res = numberOfDifferentTriangles(arr, arr.length);
        System.out.println(res);
    }
}
