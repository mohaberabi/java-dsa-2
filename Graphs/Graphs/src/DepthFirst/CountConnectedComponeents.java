package DepthFirst;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CountConnectedComponeents {


    void dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;

        for (int u : adj.get(s)) {
            if (!visited[u]) {
                dfsRec(adj, u, visited);
            }
        }
    }


    int countConnectedComponentsUsingDfs(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        int res = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, visited);
                res++;
            }
        }
        return res;
    }
}
