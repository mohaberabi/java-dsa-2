import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOnlyQueues {


    Queue<Integer> queue1;
    Queue<Integer> queue2;


    StackUsingOnlyQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }


    void push(int x) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }


    int size() {
        return queue1.size();
    }

    Integer peek() {
        return queue1.isEmpty() ? null : queue1.peek();
    }


    boolean isEmpty() {
        return queue1.isEmpty();
    }


    Integer pop() {
        if (queue1.isEmpty()) {
            return null;
        } else {
            int p = queue1.poll();
            return p;
        }
    }
}
