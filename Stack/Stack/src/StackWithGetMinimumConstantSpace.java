import java.util.ArrayList;

public class StackWithGetMinimumConstantSpace {


    /// this class assumes user will not add any negative values to the stack
    private ArrayList<Integer> stack;
    private int minimum;

    private int top;

    StackWithGetMinimumConstantSpace() {

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
        } else if (minimum >= x) {

            stack.add(++top, x - minimum);
            minimum = x;
        } else {
            stack.add(++top, x);
        }

    }


    Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return stack.get(top) <= 0 ? minimum : stack.get(top);
    }


    Integer minimum() {
        if (minimum == -1) {
            return null;
        }
        return minimum;
    }

    Integer pop() {
        if (isEmpty()) {
            return null;
        }

        int popped = stack.get(top);
        top--;
        if (popped <= 0) {
            int res = minimum;
            minimum = minimum - popped;
            return res;
        }
        return popped;

    }


    public static void main(String[] args) {
        StackWithGetMinimumConstantSpace stack1 = new StackWithGetMinimumConstantSpace();


        stack1.push(5);
        stack1.push(10);
        stack1.push(20);
        stack1.push(2);
        int min = stack1.minimum();
        int peek = stack1.peek();
        System.out.println(peek);
        System.out.println(min);
    }

}
