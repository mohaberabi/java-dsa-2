import java.util.PriorityQueue;

public class KClosethstElements {


    static class Pair {
        int index;
        int diff;

        Pair(int i, int d) {
            index = i;
            diff = d;
        }
    }


    void printKClothestOptimal(int[] arr, int n, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, Math.abs(arr[i] - x)));
        }


        for (int i = k; i < n; i++) {
            int diff = Math.abs(arr[i] - x);
            if (pq.peek().diff < diff) {
                pq.poll();
                pq.add(new Pair(i, diff));
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(arr[pq.poll().index]);
        }
    }

    void printKClothest(int[] arr, int n, int x, int k) {
        boolean[] visited = new boolean[n];


        for (int i = 0; i < k; i++) {

            int minDiff = Integer.MAX_VALUE;
            int mindDixIdx = 0;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && Math.abs(arr[j] - x) <= minDiff) {
                    minDiff = Math.abs(arr[j] - x);
                    mindDixIdx = j;
                }
            }

            System.out.println(arr[mindDixIdx]);
            visited[mindDixIdx] = true;
        }

    }
}
