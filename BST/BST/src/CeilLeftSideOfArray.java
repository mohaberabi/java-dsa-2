import java.util.TreeSet;

public class CeilLeftSideOfArray {

    static void printLeftCeilOptimal(int[] arr, int n) {

        TreeSet<Integer> set = new TreeSet<>();


        set.add(arr[0]);
        System.out.println(-1);
        for (int i = 1; i < n; i++) {

            if (set.ceiling(arr[i]) != null) {
                System.out.println(set.ceiling(arr[i]));
            } else {
                System.out.println(-1);
            }
            set.add(arr[i]);
        }
    }

    static void printCielOfLeftSide(int[] arr, int n) {

        System.out.println(-1);
        for (int i = 1; i < n; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    diff = Math.min(diff, arr[j] - arr[i]);
                }
            }
            if (diff == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(diff + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};

        printLeftCeilOptimal(arr, arr.length);
    }
}
