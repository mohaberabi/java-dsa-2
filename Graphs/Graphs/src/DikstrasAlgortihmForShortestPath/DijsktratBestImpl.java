package DikstrasAlgortihmForShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair> {
    int dist;
    int val;

    public Pair(int v, int d) {
        dist = d;
        val = v;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.dist, other.dist);
    }
}

public class DijsktratBestImpl {

    // under assumption  that graph [u][v]=weight
    public static int[] dijkstrasShortestPath(int[][] graph, int s) {
        int V = graph.length;
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Pair(s, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int u = pair.val;
            int distance = pair.dist;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && distance + graph[u][v] < dist[v]) {
                    dist[v] = distance + graph[u][v];
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 4, 0, 0},
                {1, 0, 4, 2, 7},
                {4, 4, 0, 3, 5},
                {0, 2, 3, 0, 4},
                {0, 7, 5, 4, 0}
        };

        int source = 0;
        int[] shortestDistances = dijkstrasShortestPath(graph, source);

        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(shortestDistances));
    }
}
