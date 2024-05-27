import java.util.PriorityQueue;

public class HuffmanCoding {


    static class Node implements Comparable<Node> {
        Node left;
        Node right;
        char character;
        int frequency;


        public Node(char c, int f) {
            left = null;
            right = null;
            character = c;
            frequency = f;
        }


        @Override
        public int compareTo(Node other) {
            return this.frequency = other.frequency;
        }
    }

    public static Node buildHuffmanTree(char[] chars, int[] frequency) {

        PriorityQueue<Node> pq = new PriorityQueue<>();


        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], frequency[i]));
        }


        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int total = left.frequency + right.frequency;
            Node root = new Node('$', total);
            root.left = left;
            root.right = right;
            pq.add(root);
        }

        return pq.peek();
    }


    public static void printHuffman(Node root, String code) {

        if (root == null) {
            return;
        }
        if (root.character != '$') {
            System.out.println(root.character + " " + code);
            return;
        }

        printHuffman(root.left, code + " 0");
        printHuffman(root.right, code + " 1");
    }


    public static void main(String[] args) {
        int[] freq = {10, 50, 20, 40, 80};
        char[] chars = {'a', 'd', 'b', 'e', 'f'};
        Node root = buildHuffmanTree(chars, freq);
        printHuffman(root, " ");

    }

    static String decodeHuffmanData(Node root, String binaryString) {


        StringBuilder sb = new StringBuilder();
        Node curr = root;

        for (char bit : binaryString.toCharArray()) {
            if (bit == '0') {
                curr = curr.left;
            } else if (bit == '1') {
                curr = curr.right;
            }
            if (curr.character != '$') {
                sb.append(curr.character);
                curr = root;
            }
        }


        return sb.toString();
        // add your code here
    }

}
