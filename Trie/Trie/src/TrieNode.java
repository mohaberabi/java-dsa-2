public class TrieNode {


    boolean isEndOfWord;

    TrieNode[] children;


    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
