public class DisjointSet {


    int[] parent;


    int n;

    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        initialize();
    }


    void initialize() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    void union(int x, int y) {
        int xP = find(x);
        int yP = find(y);
        if (xP == yP) {
            return;
        }
        parent[yP] = xP;
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
}
