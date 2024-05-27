import java.util.ArrayList;

public class StackWithGetMinimumAllHandeld {


    private ArrayList<Integer> stack;
    private int minimum;

    private int top;

    StackWithGetMinimumAllHandeld() {

        stack = new ArrayList<>();
        minimum = -1;
        top = -1;
    }


    boolean isEmpty() {
        return top == -1;
    }

    void push(int x) {
        if (isEmpty()) {

            stack.add(++top, x);
            minimum = x;
        } else if (x <= minimum) {

            stack.add(++top, 2 * x - minimum);
            minimum = x;


        } else {
            stack.add(++top, x);
        }
    }


    Integer peek() {
        if (top == -1) {
            return null;
        }

        int p = stack.get(top);

        return Math.max(p, minimum);
    }

    Integer pop() {
        if (top == -1) {
            return null;
        }
        int popped = stack.get(top);
        if (popped <= minimum) {
            int res = minimum;
            minimum = 2 * minimum - popped;
            return res;
        } else {
            return popped;
        }
    }
}
