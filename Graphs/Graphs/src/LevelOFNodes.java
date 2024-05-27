import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOFNodes {
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int x) {


        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] level = new int[V];

        queue.offer(0);
        visited[0] = true;
        level[0] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int neighbor : adj.get(u)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    level[neighbor] = level[u] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return (level[x] != 0) ? level[x] : -1;

    }
}
