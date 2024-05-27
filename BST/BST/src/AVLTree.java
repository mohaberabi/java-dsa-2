public class AVLTree {


    Node root;


    int height(Node root) {
        if (root == null) {
            return 0;
        }

        return root.height;
    }


    int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }


    Node leftRotate(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    Node insert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        }

        if (x < node.data) {
            node.left = insert(node.left, x);
        } else if (x > node.data) {
            node.right = insert(node.right, x);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && x < node.left.data) {
            return rightRotate(node);
        }
        if (balance < -1 && x > node.right.data) {
            return leftRotate(node);
        }
        if (balance > 1 && x > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && x < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;

    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        tree.preOrder(tree.root);
    }
}
