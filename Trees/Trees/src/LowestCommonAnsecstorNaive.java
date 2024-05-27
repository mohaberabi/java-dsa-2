import java.util.ArrayList;

public class LowestCommonAnsecstorNaive {


    boolean findPath(ArrayList<Node> p, Node root, int n) {


        if (root == null) {
            return false;
        }
        p.add(root);

        if (root.data == n) {
            return true;
        }

        if (findPath(p, root.left, n) || findPath(p, root.right, n)) {
            return true;
        }

        p.remove(p.size() - 1);

        return false;
    }


    Node lca(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!findPath(path1, root, n1) || !findPath(path2, root, n2)) {
            return null;
        }
        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1) != path2.get(i + 1)) {
                return path1.get(i);
            }
        }

        return null;
    }
}
