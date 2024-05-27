public class CountOnesReversedBinaryArra {


    static int countOnesInReversedBinaryArray(int[] arr, int n) {
        int index = search(arr, n);

        return index + 1;
    }

    static int search(int[] arr, int n) {
        int low = 0;
        int high = n - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == 1) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 0, 0, 0};

        int res = countOnesInReversedBinaryArray(arr, arr.length);
        System.out.println(res);
    }
}
