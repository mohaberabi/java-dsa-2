package TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologialSortingKhansAlgorithm {


    static void topologicalSorting(ArrayList<ArrayList<Integer>> adj, int V) {


        int[] indegree = new int[V];

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }

        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(3);
        adj.get(1).add(4);
        adj.get(1).add(3);
        topologicalSorting(adj, V);

    }

}
