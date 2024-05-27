package TopologicalSorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingToDetectCycle {


    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int u : adj.get(i)) {

                indegree[u]++;
                visited[u] = true;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();

            count++;

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
        return (count != V);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(4).add(1);
        boolean isCycle = hasCycle(adj, V);
        System.out.println(isCycle);
    }
}
