package BreadthFirst;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfConnectedComponents {


    static void bfs(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {

        visited[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }

    static int countNumberOfConnectedComponents(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int res = 0;
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        int res = countNumberOfConnectedComponents(al);
        System.out.println(res);
    }

}
