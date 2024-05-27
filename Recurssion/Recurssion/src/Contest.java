import java.util.Collections;
import java.util.PriorityQueue;

public class Contest {


    static int kthMaximumElement(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for (int x : arr) {
            pq.add(x);
        }


        int max = 0;

        for (int i = 0; i < k; i++) {
            int x = pq.poll();
            max = x;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 35, 38, 20, 25};
        int max = kthMaximumElement(arr, arr.length, 3);
        System.out.println(max);
    }
}
