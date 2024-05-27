import java.util.ArrayList;

public class PossiblePathes {
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {


        boolean[] visited = new boolean[V];


        dfsRec(adj, visited, source, destination);

        return path;

    }


    int path = 0;


    void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source, int destination) {


        visited[source] = true;

        if (source == destination) {
            path++;
        } else {
            for (int v : adj.get(source)) {
                if (!visited[v]) {
                    dfsRec(adj, visited, v, destination);
                }
            }
        }

        visited[source] = false;
    }

}
