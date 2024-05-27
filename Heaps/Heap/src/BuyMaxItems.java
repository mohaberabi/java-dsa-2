import java.util.PriorityQueue;

public class BuyMaxItems {


    static int maxItems(int[] arr, int n, int sum) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.add(x);
        }

        int res = 0;
        while (!pq.isEmpty()) {

            if (sum < pq.peek()) {
                return res;
            }
            sum -= pq.poll();
            res++;

        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 12, 5, 111, 200};

        int res = maxItems(arr, arr.length, 10);
        System.out.println(res);
    }
}
