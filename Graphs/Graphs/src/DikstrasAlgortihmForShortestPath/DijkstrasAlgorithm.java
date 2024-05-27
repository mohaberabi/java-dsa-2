package DikstrasAlgortihmForShortestPath;

import java.util.Arrays;

public class DijkstrasAlgorithm {


    int[] dijkstras(int[][] graph, int V, int s) {

        int[] dist = new int[V];


        boolean[] relaxed = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;

        for (int count = 0; count < V; count++) {
            int u = -1;

            for (int i = 0; i < V; i++) {
                if (!relaxed[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            relaxed[u] = true;
            for (int v = 0; v < V; v++) {

                if (!relaxed[v] && graph[u][v] != 0) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }
        return dist;
    }
}
