public class AnagramSearchOptimal {


    static boolean areSame(int[] a, int[] b) {

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] != b[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static final int CHAR = 256;


    static boolean searchAnagram(String text, String pattern) {
        int[] textCounter = new int[CHAR];
        int[] patternCounter = new int[CHAR];
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i < m; i++) {
            textCounter[text.charAt(i)]++;
            patternCounter[pattern.charAt(i)]++;
        }

        for (int i = m; i < n; i++) {
            if (areSame(patternCounter, textCounter)) {
                return true;
            }
            textCounter[text.charAt(i)]++;
            textCounter[text.charAt(i - m)]--;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "timetopractice";
        String b = "toc";
        boolean res = searchAnagram(a, b); // false
        System.out.println(res);
    }
}
