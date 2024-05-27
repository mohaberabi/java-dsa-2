public class TwoRepeatedElements {


    static void reverseArray(int[] arr) {


        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int getRepeated(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);


        slow = arr[0];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 3};
        int repeated1 = getRepeated(arr);
        System.out.println(repeated1);
        reverseArray(arr);

        int repeated2 = getRepeated(arr);
        System.out.println(repeated2);

    }

}
