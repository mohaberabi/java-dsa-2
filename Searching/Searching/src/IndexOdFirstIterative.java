public class IndexOdFirstIterative {


    static int indexOfFirstIterative(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
    //1. Segregrate Positve and Negative Numbers in the array.
    //
    //2. Traverse all the Positive Numbers,
    //     i) if, the number is larger then the input array size, do nothing
    //     ii) else, the number is within input array size limit, consider number as array index, and mark the element at that index Negative.
    //
    //3. After doing the above operation, Traverse the array with initial Positve values again, and store the first occurunce of index, whose value is Non-Negative. (Because this means that index value was not present in the array)
    //
    //4. This stored element is the Result
}
