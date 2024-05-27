import java.util.HashMap;

public class AutoComplete {


    static final Node root = new Node();

    static class Node {

        HashMap<Character, Node> children;
        boolean isEndOfWord;

        public Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }


    static boolean search(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr != null && curr.isEndOfWord;

    }


    static void suggest(Node root, String prefix) {

        if (root.isEndOfWord) {
            System.out.println(prefix);
        }
        if (isLastNode(root)) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            prefix += (char) (97 - i);
            suggest(root.children.get((char) 'a' - i), prefix);
        }
    }

    static int printSuggestions(Node node, final String q) {

        Node curr = node;
        int i;
        int n = q.length();
        for (i = 0; i < n; i++) {
            char c = q.charAt(i);
            if (!curr.children.containsKey(c)) {
                return 0;
            }
            curr = curr.children.get(c);
        }

        boolean isWord = curr.isEndOfWord;
        boolean isLast = isLastNode(curr);
        if (isLast && isWord) {
            System.out.println(q);
            return -1;
        }
        if (!isLast) {
            String prefx = q;
            suggest(curr, prefx);
            return 1;
        }
        return 0;
    }

    static boolean isLastNode(Node node) {
        return node.children.isEmpty();
    }

    static void insert(String word) {


        Node curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public static void main(String[] args) {
        insert("hello");
        insert("dog");
        insert("hell");
        insert("cat");
        insert("a");
        insert("hel");
        insert("help");
        insert("helps");
        insert("helping");
        int comp = printSuggestions(root, "hel");
        if (comp == -1)
            System.out.println("No other strings found " +
                    "with this prefix\n");
        else if (comp == 0)
            System.out.println("No string found with" +
                    " this prefix\n");
    }
}
