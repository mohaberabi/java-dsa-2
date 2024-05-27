import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeleteMiddleOfStack {


    public static void deleteMid(Stack<Integer> s, int sizeOfStack) {

        int mid = sizeOfStack / 2;


        Stack<Integer> aux = new Stack<>();

        if (s.peek() == null) {
            return;
        }
        int i = 0;
        while (!s.isEmpty() && i < mid) {
            int pop = s.pop();
            aux.push(pop);
            i++;
        }
        s.pop();
        while (!aux.isEmpty()) {

            int pop = aux.pop();
            s.push(pop);
        }
//        for (int x : s) {
//            System.out.print(x + " ");
//        }

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        deleteMid(s, s.size());
    }
}
