public class WaveArray {


    static void waveArray(int[] arr, int n) {


        for (int i = 0; i < n - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }


    static void swap(int[] arr, int i, int j) {


        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 9, 10};

        waveArray(arr, arr.length);
        for (int x : arr) {
            System.out.print(x);
        }
    }
}
