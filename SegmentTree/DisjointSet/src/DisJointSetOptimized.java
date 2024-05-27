public class DisJointSetOptimized {


    int[] parent;
    int[] rank;
    int n;


    public DisJointSetOptimized(int n) {
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
