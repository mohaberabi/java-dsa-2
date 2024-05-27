public class Anagram {


    boolean isAnagram(String a, String b) {

        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        String aSorted = new String(aArr);
        String bSorted = new String(bArr);

        return aSorted.equals(bSorted);
    }


    boolean anagramOptimal(String a, String b) {
        int[] count = new int[256];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
