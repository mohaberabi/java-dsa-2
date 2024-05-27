import com.sun.source.util.Trees;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveCommonAndConcatente {


    static String removeAndConcatenate(String a, String b) {
        Set<Character> s = new TreeSet<>();

        for (char c : a.toCharArray()) {
            s.add(c);
        }
        for (char c : b.toCharArray()) {
            if (s.contains(c)) {
                s.remove(c);
            } else {
                s.add(c);
            }

        }

        StringBuilder sb = new StringBuilder();

        for (char c : s) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "aacdb";
        String b = "gafd";
        String ans = removeAndConcatenate(a, b);
        System.out.println(ans);
    }

}
