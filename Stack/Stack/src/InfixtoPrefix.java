import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixtoPrefix {

    static int presedence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 1;
        }
    }


    static boolean isOperand(char c) {
        return Character.isLetter(c);
    }

    static boolean isLeft(char c) {
        return c == '(';
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
    }

    static boolean isRight(char c) {
        return c == ')';
    }

    static String prefix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (isOperand(c)) {
                sb.append(c);
            } else if (isLeft(c)) {
                stack.push(c);
            } else if (isRight(c)) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char popped = stack.pop();
                    if (isOperator(popped)) {
                        sb.append(popped);
                    }
                }
                stack.pop(); // Pop the '('
            } else if (isOperator(c)) {
                if (stack.isEmpty() || isLeft(stack.peek())) {
                    stack.push(c);
                } else if (presedence(c) > presedence(stack.peek())) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && presedence(stack.peek()) >= presedence(c)) {
                        char pop = stack.pop();
                        sb.append(pop);
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            char pop = stack.pop();
            sb.append(pop);
        }

        String reversedPrefix = reverse(sb.toString());
        return reversedPrefix;


    }

    static String reverse(String prefixRev) {
        char[] arr = prefixRev.toCharArray();
        int i = 0;
        int j = prefixRev.length() - 1;
        while (i <= j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        String prefix = new String(arr);
        return prefix;
    }

    public static void main(String[] args) {

        String ex = "x+y*z/w+u";


        String prefix = prefix(ex);
        System.out.println(prefix);
    }
}
