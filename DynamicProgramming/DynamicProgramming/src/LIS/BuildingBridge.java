package LIS;

import java.util.ArrayList;
import java.util.Collections;

public class BuildingBridge {


    public static class Bride implements Comparable<Bride> {
        int source;
        int dist;

        @Override
        public int compareTo(Bride other) {
            return source - other.source == 0 ? dist - other.dist : source - other.source;
        }

        public Bride(int s, int d) {
            source = s;
            dist = d;
        }
    }


    static int maximumBridges(ArrayList<Bride> brides) {
        Collections.sort(brides);
        int[] distinations = new int[brides.size()];
        int idx = 0;
        for (Bride bride : brides) {
            distinations[idx++] = bride.dist;
        }


        int lis = lis(distinations);
        return lis;
    }


    static int lis(int[] arr) {
        int n = arr.length;


        int[] tail = new int[n];
        tail[0] = 1;
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int c = ceil(arr, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    static int ceil(int[] arr, int low, int high, int x) {

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        ArrayList<Bride> bridges = new ArrayList<>();
        bridges.add(new Bride(6, 2));
        bridges.add(new Bride(4, 3));
        bridges.add(new Bride(1, 6));
        bridges.add(new Bride(1, 5));
        int maxBridges = maximumBridges(bridges);
        System.out.println(maxBridges);
    }
}
