import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class TarjansAlgorithm {


    static int time = 0;

    static void tarjansAlgorithm(ArrayList<ArrayList<Integer>> adj, int V) {


        boolean[] visited = new boolean[V];

        int low[] = new int[V];
        int[] disc = new int[V];

        boolean[] stackMember = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                tarjansRec(adj, low, disc, visited, stackMember, stack, i);

            }
        }
    }


    static void tarjansRec(ArrayList<ArrayList<Integer>> adj, int[] low, int[] disc, boolean[] visited, boolean[] stackMember, Stack<Integer> stack, int u) {

        visited[u] = true;
        stackMember[u] = true;
        disc[u] = low[u] = ++time;
        stack.push(u);

        for (int v : adj.get(u)) {

            if (!visited[v]) {
                tarjansRec(adj, low, disc, visited, stackMember, stack, v);
                low[u] = Math.min(low[v], low[u]);

            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (low[u] == disc[u]) {
            while (true) {
                int found = stack.pop();
                stackMember[found] = false;
                System.out.print(found + " ");
                if (found == u) {
                    break;
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);
        tarjansAlgorithm(adj, V);
    }
}
