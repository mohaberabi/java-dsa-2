import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


class CityGenerator {


    static class Node {
        boolean isEndOfWord;


        HashMap<Character, Node> children;


        public Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }


    static int search(Node root, String word) {

        int i = 0;
        for (i = 0; i < word.length(); i++) {
            if (root.children.containsKey(word.charAt(i))) {
                return i;
            }
            root = root.children.get(word.charAt(i));
        }
        if (!root.isEndOfWord) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    static void renameCities(String[] arr, int n) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        Node root = new Node();


        for (int i = 0; i < n; i++) {
            int k = search(root, arr[i]);
            String s = arr[i];
            if (k == Integer.MAX_VALUE) {
                if (tree.containsKey(s)) {
                    int val = tree.get(s);
                    val++;
                    tree.put(s, val);
                } else {
                    tree.put(s, 1);
                    System.out.print(s);
                    if (tree.get(s) > 1) {
                        System.out.print(" " + tree.get(s));
                        System.out.println();
                    }
                }
            } else {
                for (int j = 0; j <= k; j++) {
                    if (j < s.length()) {
                        System.out.println(s.charAt(j));

                    }
                }
                insert(root, s);
                if (tree.containsKey(s)) {
                    int val = tree.get(s);
                    val++;
                    tree.put(s, val);
                } else {
                    tree.put(s, 1);

                    if (tree.get(s) > 1)
                        System.out.print(" " + tree.get(s));
                    System.out.println();
                }
            }
        }
    }

    static void insert(Node root, String word) {
        Node curr = root == null ? new Node() : root;

        for (char c : word.toCharArray()) {

            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }

            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;

    }


    public static void main(String[] args) {
        String[] cities = {"shimla", "safari", "jammu", "delhi", "jammu", "dehradun"};
        renameCities(cities, cities.length);
    }
}



