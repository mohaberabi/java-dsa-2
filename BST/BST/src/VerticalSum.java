import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {


    static void printVerticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        printVerticalSumOfBst(root, map, 0);


        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getValue());
        }
    }

    static void printVerticalSumOfBst(Node root, TreeMap<Integer, Integer> map, int num) {
        if (root == null) {
            return;
        }

        if (map.containsKey(num)) {
            int v = map.get(num);
            map.put(num, v + root.data);
        } else {
            map.put(num, root.data);
        }


        printVerticalSumOfBst(root.left, map, num - 1);
        printVerticalSumOfBst(root.right, map, num + 1);
    }


    public static void main(String[] args) {

        Node root = new Node(10);
        Node left = new Node(20);
        left.left = new Node(30);
        left.right = new Node(40);
        root.left = left;
        root.right = new Node(50);
        printVerticalSum(root);
    }
}
