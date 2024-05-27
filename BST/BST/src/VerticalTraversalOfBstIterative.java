import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversalOfBstIterative {


    static class Pair {

        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }


    void constructVertical(Node root) {

        if (root == null) {
            return;
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (map.containsKey(curr.hd)) {
                map.get(curr.hd).add(curr.node.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(curr.node.data);
                map.put(curr.hd, al);
            }
            if (curr.node.left != null) {
                q.add(new Pair(curr.node.left, curr.hd - 1));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.hd + 1));
            }
        }
    }
}
