public class Node {


    public int data;
    public Node left;
    public Node right;
    public int height;
    public int leftCount;

    public Node(int x) {
        data = x;
        height = 1;
        leftCount = 0;
    }
}
