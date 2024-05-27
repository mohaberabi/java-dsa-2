//public class LexographicalRankOfAString {
//
//
//    int fact(int n) {
//        int res = 1;
//
//        for (int i = 2; i <= n; i++) {
//            res *= i;
//        }
//
//        return res;
//    }
//
//    int lexographicalRank(String s) {
//        int res = 1;
//        int n = s.length();
//        int mul = fact(n);
//        int[] count = new int[256];
//        for (int i = 0; i < n; i++) {
//            count[s.charAt(i)]++;
//        }
//        for (int i = 1; i < 256; i++) {
//            count[i] += count[i - 1];
//        }
//        for (int i = 0; i < n - 1; i++) {
//            mul = mul / (n - i);
//            res = res + count[s.charAt(i) - 1] * mul;
//            for (int j = s.charAt(i); j < 256; j++) {
//                count[j]--;
//            }
//        }
//        return res;
//    }
//
//    static int MOD = 1000000007;
//
//    //Function to generate the list of factorials.
//    static void initializeFactorials(int totalLen, ArrayList<Integer> fact) {
//        long factorial = 1;
//        fact.add((int) 1);
//        for (int curIndex = 1; curIndex < totalLen; curIndex++) {
//            factorial = (factorial * curIndex) % MOD;
//            fact.add((int) factorial);
//        }
//        return;
//    }
//
//    //Function to find lexicographic rank of a string.
//    static long findRank(String S) {
//        int charCount[] = new int[256];
//        Arrays.fill(charCount, 0);
//
//        //counting the characters of the string.
//        for (int i = 0; i < S.length(); i++) {
//            charCount[S.charAt(i)]++;
//            //returning 0 if any character is repeated.
//            if (charCount[S.charAt(i)] > 1)
//                return 0;
//        }
//
//        ArrayList<Integer> fact = new ArrayList<>();
//        initializeFactorials(S.length() + 1, fact);
//
//        long rank = 1;
//
//        //iterating over the string.
//        for (int i = 0; i < S.length(); i++) {
//            int less = 0;
//            for (int ch = 0; ch < S.charAt(i); ch++) {
//                less += charCount[ch];
//            }
//
//            //calculating the rank.
//            rank = (rank + ((long) fact.get(S.length() - i - 1) * less)) % MOD;
//            //updating the character count.
//            charCount[S.charAt(i)]--;
//        }
//        //returning the rank.
//        return rank;
//    }
//}
