package MinimumSpanningTree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class PrimsAlgorithm {


    int minimumSpanningTree(int[][] graph, int V) {
        int[] key = new int[V];
        int res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        boolean[] mst = new boolean[V];


        for (int count = 0; count < V; count++) {
            int u = -1;

            for (int i = 0; i < V; i++) {
                if (!mst[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }

            }
            mst[u] = true;
            res = res + key[u];
            for (int v = 0; v < V; v++) {
                if (!mst[u] && graph[u][v] != 0 && graph[u][v] < key[u]) {
                    key[u] = graph[u][v];
                }
            }
        }
        return res;
    }

    int minimumSpanningTree(int[][] graph) {
        int V = graph.length;
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] mst = new boolean[V];
        int res = 0;

        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!mst[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }
            mst[u] = true;
            res += key[u];
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mst[v]) {
                    key[v] = Math.min(key[v], graph[u][v]);
                }
            }
        }
        return res;
    }
}
