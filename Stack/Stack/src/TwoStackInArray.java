public class TwoStackInArray {
    private int top1;
    private int top2;
    int[] arr;
    int capacity;


    public TwoStackInArray(int cap) {
        capacity = cap;
        arr = new int[cap];
        top1 = -1;
        top2 = cap;
    }


    boolean push1(int x) {

        if (top1 < top2 - 1) {
            arr[++top1] = x;
            return true;
        }

        return false;
    }

    boolean push2(int x) {

        if (top1 < top2 - 1) {
            arr[--top2] = x;
            return true;
        }

        return false;

    }

    Integer pop1() {
        if (top1 >= 0) {
            int popped = arr[top1];
            top1--;
            return popped;
        }

        return null;
    }

    Integer pop2() {
        if (top2 <= arr.length - 1) {
            int popped = arr[top2];
            top2++;
            return popped;
        }
        return null;
    }

    int size1() {
        return top1 + 1;
    }

    int size2() {
        return arr.length - top2;
    }

}
