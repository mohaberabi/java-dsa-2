public class Helpers {


    public static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int totalArraySum(int[] arr, int n) {


        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;

    }

    public static void reverseArray(int[] arr, int low, int high) {
        while (low < high) {
            swapArr(arr, low, high);
            low++;
            high--;
        }
    }

    public static void reverseArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            swapArr(arr, low, high);
            low++;
            high--;
        }
    }
}
