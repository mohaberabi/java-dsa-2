import java.lang.reflect.Array;
import java.util.ArrayList;

public class BridgesInGraph {


    static int time = 0;


    static void printBridges(ArrayList<ArrayList<Integer>> al, int V) {


        boolean[] visited = new boolean[V];

        int[] parent = new int[V];
        int[] low = new int[V];
        int[] disc = new int[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsRec(al, low, visited, disc, parent, i);
            }
        }
    }


    static void dfsRec(ArrayList<ArrayList<Integer>> al, int[] low, boolean[] visited, int[] disc, int[] parent, int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        for (int v : al.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                dfsRec(al, low, visited, disc, parent, v);
                low[u] = Math.min(low[v], low[u]);
                if (low[v] > disc[u]) {
                    System.out.println(u + " " + v + " " + " is a bridge");
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }


    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);
        printBridges(adj, V);
    }
}
