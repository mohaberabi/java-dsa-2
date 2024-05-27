package LIS;

import java.util.Arrays;

public class LongestChainOfPair {


    public static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int f, int s) {
            first = f;
            second = s;
        }

        @Override
        public int compareTo(Pair o) {
            return first - o.first;
        }
    }


    static int lis(int[] arr) {
        int n = arr.length;

        int[] tail = new int[n];

        tail[0] = arr[0];
        int len = 1;


        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int c = ceil(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }

        return len;

    }

    static int ceil(int[] arr, int low, int high, int x) {

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    static int longestChain(Pair[] arr) {
        Arrays.sort(arr);
        int[] vals = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            vals[i] = arr[i].first;
        }
        int lis = lis(vals);
        return lis;
    }

    public static void main(String[] args) {

        Pair[] pairs = {
                new Pair(5, 24),
                new Pair(39, 60),
                new Pair(15, 28),
                new Pair(27, 40),
                new Pair(50, 90),

        };

        int chains = longestChain(pairs);
        System.out.println(chains);
    }
}
