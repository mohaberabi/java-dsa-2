import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestInStream {
    public void kthLargest(int arr[], int n, int k) {


        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            if (pq.size() < k)
                pq.add(arr[i]);
            else {

                if (arr[i] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }

            //if size of priority queue is less than k, we print -1.
            if (pq.size() < k)
                System.out.print("-1 ");
                //else we print the top element of the priority queue.
            else
                System.out.print(pq.peek() + " ");
        }
    }

}
