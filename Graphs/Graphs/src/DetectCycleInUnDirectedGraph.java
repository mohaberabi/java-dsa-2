import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUnDirectedGraph {


    static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, int parent, boolean[] visited) {

        visited[s] = true;


        for (int u : adj.get(s)) {
            if (!visited[u]) {

                if (dfsRec(adj, u, s, visited)) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;
    }


    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                if (dfsRec(adj, 0, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<>());
        }
        addEdge(al, 0, 1);
        addEdge(al, 1, 4);
        addEdge(al, 1, 2);
        addEdge(al, 2, 3);


        boolean hasCycle = hasCycle(al, V);
        System.out.println(hasCycle);
    }
}
