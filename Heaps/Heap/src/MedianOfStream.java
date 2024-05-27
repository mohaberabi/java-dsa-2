import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {


    void printMedianOfStream(int[] arr) {


        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());


        min.add(arr[0]);
        System.out.println(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            if (min.size() > max.size()) {
                if (min.peek() > x) {
                    min.add(x);
                } else {
                    max.add(x);

                }
                double med = (double) (min.peek() + max.peek()) / 2;
                System.out.println(med);
            } else {
                if (x <= min.peek()) {
                    min.add(x);
                } else {
                    max.add(x);
                    min.add(max.poll());
                }
                System.out.println(min.peek());
            }
        }

    }
}
