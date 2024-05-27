public class CloserToSort {


    static int indexOfElemntCloserToSorted(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (mid != 0 && arr[mid - 1] == x) {
                return mid - 1;
            } else if (mid != (arr.length - 1) && arr[mid + 1] == x) {
                return mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 10, 4, 40};

        int res = indexOfElemntCloserToSorted(arr, 2);
        System.out.println(res);
    }

}
