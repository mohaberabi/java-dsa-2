import java.util.ArrayList;

public class AdjacencyList {


    static void addEdge(ArrayList<ArrayList<Integer>> al, int u, int v) {
        al.get(u).add(v);
        al.get(v).add(u);
    }


    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        addEdge(al, 0, 1);
        addEdge(al, 0, 2);
        addEdge(al, 1, 2);

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                System.out.print(al.get(i).get(j));
            }
            System.out.println();
        }
    }
}
