public class FixBstWithTwoSwappedNodes {


    // given an array with all sorted except of two only , fix it


    int nil = 201098;

    int prev = Integer.MIN_VALUE;
    int first = nil;
    int second = nil;

    void fixArrayWithTwoSwapped(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] < prev) {
                if (first == nil) {
                    first = prev;
                }
                second = arr[i];
            }
            prev = arr[i];
        }
    }


}
