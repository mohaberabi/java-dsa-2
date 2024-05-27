package SingleyLinkedList;

import Shared.Node;

import java.util.HashMap;

public class LRU {


    private HashMap<Integer, Node> map;

    private int capacity;
    private int count;

    private Node head;
    private Node tail;


    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
        head.previous = null;
        tail.next = null;
    }


    public void deleteNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public void addHead(Node node) {
        node.next = head.next;
        node.next.previous = node;
        node.previous = head;
        head.next = node;
    }


    public void set(int key, int val) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.data = val;
            deleteNode(node);
            addHead(node);

        } else {
            Node node = new Node(key, val);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addHead(node);
            } else {
                map.remove(tail.previous.key);
                deleteNode(tail.previous);
                addHead(node);

            }
        }
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int res = node.data;
            deleteNode(node);
            addHead(node);
            System.out.println("Found the value " + " " + res);
            return res;
        }
        return -1;
    }
}
