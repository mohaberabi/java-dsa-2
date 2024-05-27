import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBst {


    static class Pair {
        Node node;

        int hd;

        Pair(Node n, int h) {

            node = n;
            hd = h;
        }
    }

    static void topViewOfBst(Node root) {


        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {

            Pair curr = q.poll();
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.data);
            }
            if (curr.node.left != null) {

                q.add(new Pair(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.hd + 1));

            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

            System.out.println(e.getValue());
        }

    }


    public static void main(String[] args) {


        Node root = new Node(10);
        Node left = new Node(20);
        left.left = new Node(30);
        left.right = new Node(40);
        Node right = new Node(50);
        right.left = new Node(60);
        root.left = left;
        root.right = right;
        topViewOfBst(root);
    }
}
