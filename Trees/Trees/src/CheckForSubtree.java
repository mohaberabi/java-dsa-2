public class CheckForSubtree {
    public static boolean isSubtree(Node T, Node S) {

        if (T == null) {
            return false;
        }
        if (S == null) {
            return false;
        }

        if (T == S) {
            return true;
        }
        if (sameTree(T, S)) {
            return true;
        }

        return isSubtree(T.left, S) || isSubtree(T.right, S);

        // add code here.
    }


    static boolean sameTree(Node t, Node s) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return t.data == s.data && sameTree(t.left, s.left) && sameTree(t.right, s.right);
    }
}
