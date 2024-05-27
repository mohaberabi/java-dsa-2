public class Palindrome {


    boolean isPalindromeNaive(String s) {

        StringBuilder rev = new StringBuilder(s);

        rev.reverse();

        return s.equals(rev.toString());
    }

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }


    public static void main(String[] args) {

        System.out.println(isPalindrome("abcdcba"));
    }
}
