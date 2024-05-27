public class LeftMostNonRepeatingCharacter {


    public static final int CHAR = 256;

    int leftMostNonRepeatedBetter(String s) {


        int[] count = new int[CHAR];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    int leftMostNonRepeatedOptimal1(String s) {
        int[] fi = new int[CHAR];
        for (int i = 0; i < s.length(); i++) {
            if (fi[s.charAt(i)] == -1) {
                fi[s.charAt(i)] = i;
            } else {
                fi[s.charAt(i)] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < CHAR; i++) {
            if (fi[i] > 0) {
                res = Math.min(res, fi[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
