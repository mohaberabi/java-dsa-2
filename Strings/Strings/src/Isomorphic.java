import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {


    public static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (charMap.containsKey(c2)) {
                return false;
            }
            charMap.put(c1, c2);
        }
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (charMap.get(c1) != c2 || charMap.containsKey(c2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "aab";
        String b = "xxy";
        boolean res = areIsomorphic(a, b);
        System.out.println(res);
    }
}
