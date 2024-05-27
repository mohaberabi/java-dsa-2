import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversalOfBst {


    static void constructVertialTraversalOfBst(Node root, TreeMap<Integer, ArrayList<Integer>> map, int num) {
        if (root == null) {
            return;
        }
        constructVertialTraversalOfBst(root.left, map, num - 1);

        if (map.containsKey(num)) {
            map.get(num).add(root.data);
        } else {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(root.data);
            map.put(num, al);
        }

        constructVertialTraversalOfBst(root.right, map, num + 1);

    }

    static void printVerticalTraversal(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        constructVertialTraversalOfBst(root, map, 0);


        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            for (int x : e.getValue()) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        Node right = new Node(30);
        right.left = new Node(40);
        right.right = new Node(50);
        root.left = new Node(20);
        root.right = right;
        printVerticalTraversal(root);
    }
}
