package TopologicalSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathDAGUsingTopologicalSorting {


    int[] shortestPathDAGTopologicalSorting(ArrayList<ArrayList<Integer>> adj, int V) {


        int[] dist = new int[V];

        ArrayList<Integer> topological = topologicalSorting(adj, V);
        dist[0] = 0;

        for (int u : topological) {
            for (int v : adj.get(u)) {
                if (dist[v] > dist[u] + adj.get(u).get(v)) {
                    dist[v] = adj.get(u).get(v);
                }
            }
        }
        return dist;
    }


    ArrayList<Integer> topologicalSorting(ArrayList<ArrayList<Integer>> adj, int V) {


        boolean[] visited = new boolean[V];


        int[] indegree = new int[V];

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();


        for (int v = 0; v < V; v++) {
            for (int u : adj.get(v)) {
                indegree[u]++;
            }
        }

        for (int d : indegree) {
            if (d == 0) {
                q.add(d);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    indegree[v]--;
                    visited[v] = true;
                    if (indegree[v] == 0) {
                        q.add(v);
                    }
                }
            }
        }
        return topo;
    }
}
