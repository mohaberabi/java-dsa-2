public class Trie {
    Node root;

    Trie() {
        root = new Node();
    }


    boolean isEmpty(Node node) {

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }


    Node delete(String word) {
        return delete(0, word);
    }

    Node delete(int i, String word) {
        if (root == null) {
            return null;
        }

        if (i == word.length()) {
            root.isEndOfWord = false;

            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }
        int index = word.charAt(i) - 'a';

        root.children[index] = delete(i + 1, word);
        if (isEmpty(root) && !root.isEndOfWord) {
            root = null;
        }
        return root;
    }

    boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("mohab");

        boolean exist = trie.search("mohab");

        trie.delete(0, "mohab");
        System.out.println(exist);

        boolean sea = trie.search("mohab");
        System.out.println(sea);
    }
}
