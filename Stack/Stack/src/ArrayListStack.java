import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack<T> {


    private final ArrayList<T> stack;


    public ArrayListStack() {
        stack = new ArrayList<>();
    }


    boolean isEmpty() {
        return stack.size() == 0;
    }

    int size() {
        return stack.size();
    }

    void Push(T t) {
        stack.add(t);
    }

    T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T t = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return t;
        }
    }

    T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();

        } else {
            return stack.get(stack.size() - 1);
        }
    }
}
