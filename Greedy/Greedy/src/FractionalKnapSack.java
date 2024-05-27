import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapSack {


    static class Pair implements Comparable<Pair> {
        int value;
        int weight;


        public Pair(int w, int v) {
            weight = w;
            value = v;
        }

        @Override
        public int compareTo(Pair other) {

            return (other.value / other.weight) - (this.value / this.weight);
        }
    }


    public static double fractionalKnapSack(ArrayList<Pair> items, double capacity) {
        Collections.sort(items);
        double currentCap = capacity;
        double res = 0;
        for (Pair item : items) {
            if (item.weight <= currentCap) {
                res += item.value;
                currentCap -= item.weight;
            } else {
                res += (item.value) * ((double) currentCap / item.weight);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Pair> items = new ArrayList<>();
        items.add(new Pair(10, 60));
        items.add(new Pair(40, 40));
        items.add(new Pair(20, 100));
        items.add(new Pair(30, 120));

        double res = fractionalKnapSack(items, 50);
        System.out.println(res);
//
//        Pair[] arr = {};
//        Arrays.sort(arr, new MyComb());
    }

//    static public class MyComb implements Comparator<Pair> {
//
//        @Override
//        public int compare(Pair o1, Pair o2) {
//            return 0;
//        }
//    }
}
