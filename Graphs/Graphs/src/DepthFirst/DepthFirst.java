package DepthFirst;

import java.util.ArrayList;

public class DepthFirst {


    void dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {

        System.out.println(s);
        visited[s] = true;

        for (int u : adj.get(s)) {
            if (!visited[u]) {
                dfsRec(adj, u, visited);
            }
        }


    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V];
        dfsRec(adj, s, visited);

    }
}
