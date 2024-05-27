import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElement {


    static void printKLargestElementMethod1(int[] arr, int n, int k) {


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            pq.add(x);
        }
        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll() + " ");
        }

    }


    static void kLargestElementsMethod2(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {

            int peek = pq.peek();
            if (arr[i] > peek) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 20, 8, 25, 18};
        kLargestElementsMethod2(arr, arr.length, 3);
        System.out.println();
        printKLargestElementMethod1(arr, arr.length, 3);
    }
}
