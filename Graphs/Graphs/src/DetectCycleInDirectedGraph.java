import java.util.ArrayList;

public class DetectCycleInDirectedGraph {


    static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] stackTrace) {
        visited[s] = true;

        stackTrace[s] = true;


        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (dfsRec(adj, u, visited, stackTrace)) {
                    return true;
                }

            } else if (stackTrace[u]) {
                return true;
            }
        }
        stackTrace[s] = false;
        return false;
    }


    static boolean directedGraphHasCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] stack = new boolean[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsRec(adj, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void addEdgeUnDirected(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(3);

        boolean hasCycle = directedGraphHasCycle(adj, V);
        System.out.println(hasCycle);
    }
}
