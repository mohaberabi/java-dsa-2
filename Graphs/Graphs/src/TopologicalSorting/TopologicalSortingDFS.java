package TopologicalSorting;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {


    static void topologicalSortingDFS(ArrayList<ArrayList<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, stack, visited, i);
            }
        }

        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.println(u);
        }
    }


    static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited, int u) {

        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, stack, visited, v);
            }
        }
        stack.push(u);
    }


    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int V = 5;

        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(1);
        al.get(1).add(3);
        al.get(2).add(3);
        al.get(2).add(4);
        topologicalSortingDFS(al, V);
    }
}
