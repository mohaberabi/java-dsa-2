public class AnagramSearch {


    public static final int CHAR = 256;


    boolean isAnagramPresent(String txt, String pat) {


        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i <= n - m; i++) {
            if (isAnagram(txt, pat, i)) {
                return true;
            }
        }
        return false;
    }

    boolean isAnagram(String a, String b, int i) {
        int[] count = new int[CHAR];


        for (int j = 0; i < CHAR; i++) {

            count[a.charAt(i)]++;
            count[b.charAt(i + j)]--;
        }


        for (int j = 0; j < CHAR; j++) {
            if (count[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
