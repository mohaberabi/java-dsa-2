package DikstrasAlgortihmForShortestPath;

import java.util.Arrays;

public class MinimumPathCost {


    static int[] dijkstras(int[][] graph, int V, int s) {
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);


        dist[s] = 0;


        boolean[] relaxed = new boolean[V];

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
                    dist[v] = Math.min(dist[v], graph[u][v] + dist[u]);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = {{9, 4, 9, 9}, {6, 7, 6, 4}, {8, 3, 3, 7}, {7, 4, 9, 10}};

        int[] dist = dijkstras(graph, V, 0);
        int minPath = 0;

        for (int x : dist) {
            minPath += x;
            System.out.print(x + " ");
        }
        System.out.println(minPath);

    }
}
