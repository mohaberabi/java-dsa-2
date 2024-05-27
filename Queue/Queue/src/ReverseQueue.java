import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    void reverseQuereRecursively(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int p = q.poll();
        reverseQueueMethod1(q);
        q.add(p);

    }

    void reverseQueueMethod1(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {

            int p = q.poll();

            stack.push(p);

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            q.add(p);
        }
    }
}
