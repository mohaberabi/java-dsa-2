package Shared;

public class Node {
    public int data;
    public Node next;
    public int key;
    public Node random;

    public boolean visited;
    public Node previous;


    public Node(int x) {
        data = x;
        key = Integer.MAX_VALUE;
        visited = false;
    }

    public Node(int x, int k) {
        data = x;
        key = k;
        visited = false;
    }
}
