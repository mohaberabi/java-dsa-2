import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CamelCase {


    static class TrNode {

        HashMap<Character, TrNode> children;
        boolean isEndOfWord;
        ArrayList<String> words;

        public TrNode() {
            children = new HashMap<>();
            isEndOfWord = false;
            words = new ArrayList<>();
        }

        void insert(String word) {
            TrNode curr = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (Character.isUpperCase(c)) {


                    if (!curr.children.containsKey(c)) {
                        curr.children.put(c, new TrNode());
                    }
                    curr = curr.children.get(c);
                }
            }
            curr.isEndOfWord = true;
            curr.words.add(word);
        }
    }


    static void printAll(TrNode node) {
        if (node.isEndOfWord) {
            Collections.sort(node.words);
            for (String s : node.words) {
                System.out.print(s + " ");
            }
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' - i);

            if (node.children.containsKey(c)) {
                printAll(node.children.get(c));

            }
        }
    }


    static boolean search(TrNode node, String pattern) {
        TrNode curr = node;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }
        printAll(curr);
        return true;
    }

    static void findWords(String[] words, String pat) {
        TrNode node = new TrNode();
        for (String x : words) {
            node.insert(x);
        }
        boolean res = search(node, pat);
        System.out.println(res ? "FOUND" : "NOT FOUND");
    }


    public static void main(String[] args) {
        String[] dict = {"Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"};
        findWords(dict, "HA");
    }
}
