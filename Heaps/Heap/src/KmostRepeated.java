import java.util.*;

public class KmostRepeated {

    //

    static class Pair implements Comparable<Pair> {
        int val;
        int freq;

        public Pair(int v, int f) {
            val = v;
            freq = f;
        }

        @Override
        public int compareTo(Pair o) {
            return o.freq - freq;

        }
    }

    static void printKMostRepeated(int[] arr, int k) {


    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        printKMostRepeated(arr, 2);
    }
}
