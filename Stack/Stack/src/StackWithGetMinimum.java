import java.util.ArrayList;
import java.util.Objects;

public class StackWithGetMinimum {


    ArrayList<Integer> mainStack;
    ArrayList<Integer> auxStack;


    int mainTop;
    int auxTop;

    StackWithGetMinimum() {

        mainStack = new ArrayList<>();
        auxStack = new ArrayList<>();
        mainTop = -1;
        auxTop = -1;
    }


    void push(int x) {

        mainStack.add(++mainTop, x);
        if (auxStack.isEmpty()) {
            auxStack.add(++auxTop, x);
        }

        if (auxStack.get(auxTop) >= mainStack.get(mainTop)) {
            auxStack.add(++auxTop, x);
        }
    }


    int getMinimum() {
        if (auxTop == -1) {
            return -1;
        } else {
            return auxStack.get(auxTop);
        }
    }

    int pop(int x) {

        if (mainTop == -1) {
            return -1;
        }
        int popped = mainStack.get(mainTop);
        mainTop--;

        int currMainTop = mainStack.get(mainTop);
        int currAuxTop = auxStack.get(auxTop);
        if (currMainTop == currAuxTop) {
            auxTop--;
        }

        return popped;
    }


    public static void main(String[] args) {
        StackWithGetMinimum stack = new StackWithGetMinimum();

        stack.push(5);
        stack.push(10);
        stack.push(20);
        stack.push(2);
        stack.push(1);

        int min = stack.getMinimum();
        System.out.println(min);

//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);

    }
}
