public class RepeatingElement {

    int repeatingElement(int[] arr, int n) {

        int fast = arr[0];
        int slow = arr[0];
        do {
            fast = arr[arr[fast]];
            slow = arr[slow];
        } while (fast != slow);


        slow = arr[0];
        while (fast != slow) {
            fast = arr[fast];
            slow = arr[slow];
        }
        return slow;
    }

    int repeatingElementZeroAlwaysAppears(int[] arr, int n) {

        int fast = arr[0] + 1;
        int slow = arr[0] + 1;
        do {
            fast = arr[arr[fast]] + 1;
            slow = arr[slow] + 1;
        } while (fast != slow);


        slow = arr[0];
        while (fast != slow) {
            fast = arr[fast] + 1;
            slow = arr[slow] + 1;
        }
        return slow;
    }
}
