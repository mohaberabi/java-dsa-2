public class ArrayStack<T> {

    static final int DEFAULT_CAPCAITY = 10;

    private T[] stack;
    private int capacity;

    int size;

    private int top;


    public ArrayStack(int cap) {
        capacity = cap;
        stack = (T[]) new Object[cap];
        top = -1;
        size = 0;
    }

    public ArrayStack() {
        capacity = DEFAULT_CAPCAITY;
        stack = (T[]) new Object[DEFAULT_CAPCAITY];
        top = -1;
        size = 0;
    }


    boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    void Push(T t) {
        if (isFull()) {
            throw new StackOverflowError();
        } else {

            stack[++top] = t;
            size++;

        }
    }

    T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            size--;
            return stack[top--];
        }
    }

    T peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();

        } else {
            return stack[top];
        }
    }
}
