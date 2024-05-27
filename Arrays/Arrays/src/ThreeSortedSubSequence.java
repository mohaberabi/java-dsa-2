import java.util.ArrayList;
import java.util.PriorityQueue;

public class ThreeSortedSubSequence {


    static ArrayList<Integer> threeSortedSubSequence(ArrayList<Integer> al, int n) {


        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(al.get(0));


        for (int i = 1; i < n; i++) {

            if (pq.peek() < al.get(i)) {
                pq.add(al.get(i));
            }
            if (pq.size() == 3) {
                new ArrayList<>(pq);
            }
        }
        for (int x : pq) {
            System.out.println(x);
        }

        return new ArrayList<>();
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 3};
    }

}
