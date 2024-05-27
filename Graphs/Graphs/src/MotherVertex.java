import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {


    int motherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);

            }
        }
        int mother = stack.pop();
        visited = new boolean[V];
        dfs(mother, adj, visited);


        for (boolean visit : visited) {
            if (!visit) {
                return -1;
            }
        }
        return mother;
    }


    void dfs(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[source] = true;
        for (int v : adj.get(source)) {
            if (!visited[v]) {
                dfs(source, adj, visited, stack);
            }
        }

        stack.push(source);
    }

    void dfs(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[source] = true;

        for (int v : adj.get(source)) {
            if (!visited[v]) {
                dfs(source, adj, visited);
            }
        }
    }
}
