import java.util.HashMap;
import java.util.Map;

public class SmallestWindowHasAllOfOtherString {
    public static String findSmallestWindow(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return "-1";
        }

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0; // Left pointer of the sliding window
        int minLen = s.length() + 1; // Initialize to a value greater than the length of S
        int minLeft = 0; // Starting index of the minimum window

        int count = 0; // Count of characters in P found in the current window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            sMap.put(currentChar, sMap.getOrDefault(currentChar, 0) + 1);

            if (pMap.containsKey(currentChar) && sMap.get(currentChar) <= pMap.get(currentChar)) {
                count++;
            }

            while (count == p.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if (pMap.containsKey(leftChar) && sMap.get(leftChar) < pMap.get(leftChar)) {
                    count--;
                }

                left++;
            }
        }

        if (minLen == s.length() + 1) {
            return "-1";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";
        String smallest = findSmallestWindow(s, p);
        System.out.println(smallest);
    }
}
