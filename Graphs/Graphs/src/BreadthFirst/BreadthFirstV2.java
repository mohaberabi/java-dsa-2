package BreadthFirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstV2 {

    // when graph is not connected and no source
    void bfs(ArrayList<ArrayList<Integer>> al, int s, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println(u);
            for (int v : al.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }


    void bfsDisconnected(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
            }
        }
    }
}
