import java.util.LinkedList;
import java.util.Queue;

public class StackOneQueueRecursive {


    Queue<Integer> queue;


    StackOneQueueRecursive() {
        queue = new LinkedList<>();
    }

    public void push(int value) {
        queue.add(value);
        recursiveRotate(queue.size() - 1);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    private void recursiveRotate(int count) {
        if (count == 0) {
            return;
        }
        int front = queue.poll();
        queue.add(front);
        recursiveRotate(count - 1);
    }


}
