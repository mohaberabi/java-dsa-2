import java.util.PriorityQueue;

public class SortKSortedArray {


    void sortKSortedArray(int[] arr, int k, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}
