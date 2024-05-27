import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class FirstCirculerTour {


    int firstCirculerTourOptimal(int[] pet, int dist[], int n) {

        int start = 0;
        int currentPetrol = 0;
        int prevPetrol = 0;


        for (int i = 0; i < n; i++) {
            currentPetrol += (pet[i] - dist[i]);

            if (currentPetrol < 0) {
                start = i + 1;
                prevPetrol += currentPetrol;
                currentPetrol = 0;
            }
        }

        return ((currentPetrol + prevPetrol) >= 0) ? start + 1 : -1;
    }

    int firstCirculerTourBetter(int[] petrol, int[] dist, int n) {
        Deque<Integer> dq = new LinkedList<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();


        int curr = 0;

        dq.addFirst(0);


        for (int i = 0; i < n; i++) {
            curr += (petrol[i] - dist[i]);
            while (!dq.isEmpty() && curr < 0) {
                int startIndex = dq.removeFirst();

                if (startIndex == 0) {
                    return startIndex + 1;
                }
                curr -= (petrol[startIndex] - dist[startIndex]);
            }
            dq.addLast(i);
        }
        return -1;
    }

    int firstCirculerTourNaive(int[] petrol, int[] dist, int n) {


        for (int start = 0; start < n; start++) {
            int curr = 0;
            int end = start;

            while (true) {
                curr += (petrol[end] - dist[end]);
                if (curr < 0) {
                    break;
                }

                end = (end + 1) % n;

                if (start == end) {
                    return start + 1;
                }
            }
        }
        return -1;

    }
}
