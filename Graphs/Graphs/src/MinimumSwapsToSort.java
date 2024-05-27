import java.util.Arrays;

public class MinimumSwapsToSort {


    static class Pair implements Comparable<Pair> {
        int val;
        int index;

        public Pair(int v, int i) {
            val = v;
            index = i;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.val, o.val);
        }
    }


    static int minimumSwaps(int[] arr) {
        int n = arr.length;

        // Create an array of pairs
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Sort the array of pairs based on element values
        Arrays.sort(pairs);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // If the element is already visited or at the correct position, continue
            if (visited[i] || pairs[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].index;
                cycleSize++;
            }

            // Calculate swaps needed for the current cycle
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }


    public static void main(String[] args) {
        int[] arr = {10, 19, 6, 3, 5};
        int res = minimumSwaps(arr);
        System.out.println(res);
    }

}
