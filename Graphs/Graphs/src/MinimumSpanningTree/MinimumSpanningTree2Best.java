package MinimumSpanningTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int to;
    int weight;


    public Edge(int t, int w) {
        to = t;
        weight = w;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class MinimumSpanningTree2Best {


    int minimumSpanningTree(int[][] graph, int V) {


        boolean[] mst = new boolean[V];
        int res = 0;

        int[] key = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        key[0] = 0;
        pq.add(new Edge(0, key[0]));

        while (!pq.isEmpty()) {
            int u = pq.poll().to;
            if (mst[u]) {
                continue;
            }
            mst[u] = true;
            res += key[u];
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    pq.add(new Edge(v, key[v]));
                }
            }
        }
        return res;
    }
}
