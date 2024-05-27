import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnWiehghtedGraph {


    static void printShortestPath(ArrayList<ArrayList<Integer>> adj, int s, int V) {

        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        dist[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        for (int d : dist) {
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(2);
        al.get(0).add(1);

        al.get(1).add(3);
        al.get(1).add(2);
        al.get(2).add(3);

        printShortestPath(al, 0, V);
    }
}
