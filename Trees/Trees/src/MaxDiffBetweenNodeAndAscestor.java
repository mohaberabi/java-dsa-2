public class MaxDiffBetweenNodeAndAscestor {

    class Res {
        int r = Integer.MIN_VALUE;
    }

    int maxDiffUtil(Node t, Res res) {
        if (t == null)
            return Integer.MAX_VALUE;

        if (t.left == null && t.right == null)
            return t.data;


        int val = Math.min(maxDiffUtil(t.left, res),
                maxDiffUtil(t.right, res));

        res.r = Math.max(res.r, t.data - val);

        return Math.min(val, t.data);
    }

    int maxDiff(Node root) {
        Res res = new Res();
        maxDiffUtil(root, res);
        //returning the result.
        return res.r;
    }


    public static void main(String[] args) {

//        Node root = new Node(5);
//        Node left = new Node(2);
//
//        Node right = new Node(1);
//
////        right.right = new Node(7);
//        root.left = left;
//        root.right = right;
//
//        int maxDiff = maxDiff(root);
//        System.out.println(maxDiff);
    }
}
