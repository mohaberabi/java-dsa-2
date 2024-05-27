import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {


    static class Edge implements Comparable<Edge> {
        int source;

        int weight;

        int destination;

        public Edge(int s, int d, int w) {

            source = s;
            destination = d;
            weight = w;
        }


        @Override
        public int compareTo(Edge o) {

            return weight - o.weight;
        }
    }


    static class DisJSet {
        int[] parent;
        int[] rank;
        int n;

        public DisJSet(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            init();
        }


        void init() {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        void union(int x, int y) {


            int xRep = find(x);
            int yRep = find(y);
            if (xRep == yRep) {
                return;
            }

            if (rank[xRep] > rank[yRep]) {

                parent[yRep] = xRep;

            } else if (rank[yRep] > rank[xRep]) {
                parent[xRep] = yRep;
            } else {
                parent[xRep] = yRep;
                rank[yRep]++;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }


    static int mst(ArrayList<Edge> graph) {
        Collections.sort(graph);
        DisJSet set = new DisJSet(graph.size());
        int res = 0;
        int V = graph.size();
        for (int i = 0, size = 0; size < V - 1; i++) {
            Edge current = graph.get(i);
            int x = set.find(current.source);
            int y = set.find(current.destination);
            if (x != y) {
                res += current.weight;
                set.union(x, y);
                size++;

            }
        }
        return res;
    }


    public static void main(String[] args) {
        Edge e1 = new Edge(0, 1, 10);
        Edge e2 = new Edge(1, 2, 5);
        Edge e3 = new Edge(1, 3, 3);
        Edge e4 = new Edge(3, 4, 15);
        Edge e5 = new Edge(2, 4, 12);

        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(e1);
        graph.add(e2);
        graph.add(e3);
        graph.add(e4);
        graph.add(e5);

        int mst = mst(graph);
        System.out.println(mst);

    }
}
