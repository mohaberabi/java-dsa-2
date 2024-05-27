import java.util.Arrays;

public class BellmanFord {


    int[] shortestPathBellmanFordAlgorithm(int[][] graph, int V, int s) {


        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        return dist;
    }
}
