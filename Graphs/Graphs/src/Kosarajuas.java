import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Kosarajuas {


    static void printStronglyConnectedComponnets(ArrayList<ArrayList<Integer>> adj, int V) {


        ArrayList<Integer> reversedDfs = reverseDfs(adj);

        ArrayList<ArrayList<Integer>> transpose = transposeOfGraph(adj);


        boolean[] visited = new boolean[V];


        for (int u : reversedDfs) {
            if (!visited[u]) {
                normalDfs(transpose, u, visited, V);
            }
        }
    }


    static void normalDfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int V) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                normalDfs(adj, u, visited, V);
            }
        }
        System.out.println();
    }


    static ArrayList<Integer> reverseDfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> al = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        boolean[] visited = new boolean[V];

        for (int u = 0; u < adj.size(); u++) {
            if (!visited[u]) {
                dfsRec(adj, u, st, visited);
            }
        }

        while (!st.isEmpty()) {
            int u = st.pop();
            al.add(u);
        }

        return al;
    }


    static ArrayList<ArrayList<Integer>> transposeOfGraph(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            transpose.add(new ArrayList<>());
        }

        for (int u = 0; u < graph.size(); u++) {
            for (int v : graph.get(u)) {

                transpose.get(v).add(u);
            }

        }

        return transpose;
    }


    static void dfsRec(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> st, boolean[] visited) {

        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsRec(adj, v, st, visited);
            }
        }

        st.push(u);

    }

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        int V = 5;
        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(2).add(0);
        adj.get(1).add(2);
        adj.get(3).add(4);
        printStronglyConnectedComponnets(adj, V);
    }
}
