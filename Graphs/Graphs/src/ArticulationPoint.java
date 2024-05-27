import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {

    public static final int nil = -1;

    static void articulationPoint(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];

        boolean[] ap = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(parent, nil);
        int[] low = new int[V];
        int[] disc = new int[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsRec(adj, visited, disc, low, i, ap, parent);
            }
        }
        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static int time = 0;

    static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                       int[] disc,
                       int[] low, int s,
                       boolean[] ap,
                       int[] parent) {


        int children = 0;

        visited[s] = true;

        disc[s] = low[s] = ++time;

        for (int v : adj.get(s)) {
            if (!visited[v]) {
                children++;
                parent[v] = s;
                dfsRec(adj, visited, disc, low, v, ap, parent);
                low[s] = Math.min(low[s], low[v]);

                if (parent[s] == nil && children > 1) {
                    ap[s] = true;
                }

                if (parent[s] != nil && low[v] >= disc[s]) {
                    ap[s] = true;
                }
            } else if (v != parent[s]) {
                low[s] = Math.min(low[s], disc[v]);
            }
        }
    }

    public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1, adj);
        addEdge(1, 4, adj);
        addEdge(4, 2, adj);
        addEdge(4, 3, adj);
        addEdge(2, 3, adj);
        articulationPoint(adj, V);

    }
}
