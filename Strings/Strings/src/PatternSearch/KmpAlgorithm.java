package PatternSearch;

public class KmpAlgorithm {


    static void fillLps(String pat, int[] lps) {
        int n = pat.length();
        int i = 1;
        int len = 0;
        lps[0] = 0;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }


    static void kmp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = new int[m];
        fillLps(pattern, lps);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j == 0) {
                    i++;
                } else {
                    
                    j = lps[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ababcababaad";
        String pat = "ababa";

        kmp(text, pat);
    }
}
