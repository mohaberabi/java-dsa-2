import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {


    public static class Entry implements Comparable<Entry> {
        int index;
        int value;
        int arrayIndex;

        public Entry(int i, int v, int ai) {
            index = i;
            value = v;
            arrayIndex = ai;
        }

        @Override
        public int compareTo(Entry o) {
            return value - o.value;
        }
    }

    static void mergeKSortedArray(ArrayList<ArrayList<Integer>> al) {
        int k = al.size();

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Entry(0, al.get(i).get(0), i));
        }
        while (!pq.isEmpty()) {
            Entry min = pq.poll();
            res.add(min.value);
            int arrayPos = min.arrayIndex;
            int vPos = min.index;
            if (vPos + 1 < al.get(arrayPos).size()) {
                pq.add(new Entry(min.index + 1, al.get(arrayPos).get(vPos + 1), min.arrayIndex));

            }
        }


        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        ArrayList<Integer> first = new ArrayList<>();
        first.add(10);
        first.add(20);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(5);
        second.add(15);
        ArrayList<Integer> third = new ArrayList<>();
        third.add(4);
        third.add(9);
        third.add(11);

        al.add(first);
        al.add(second);
        al.add(third);
        mergeKSortedArray(al);

    }

}
