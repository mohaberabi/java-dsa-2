package PatternSearch;

import java.util.ArrayList;

public class KmpAlgorithmLPS {


    void fillLps(String s, int[] lps) {
        int n = s.length();
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
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
}
