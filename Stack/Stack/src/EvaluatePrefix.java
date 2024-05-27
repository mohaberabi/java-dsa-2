import java.util.Stack;

public class EvaluatePrefix {


    static double evalate(String a, String b, char operator) {

        return switch (operator) {
            case '+' -> Double.parseDouble(b) + Double.parseDouble(a);
            case '-' -> Double.parseDouble(b) - Double.parseDouble(a);
            case '/' -> Double.parseDouble(b) / Double.parseDouble(a);
            case '*' -> Double.parseDouble(b) * Double.parseDouble(a);
            default -> Math.pow(Double.parseDouble(b), Double.parseDouble(a));
        };
    }

    static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    static double evaluatePrefix(String prefix) {
        Stack<String> s = new Stack<>();

        String pure = prefix.trim().replaceAll(" ", "");

        for (int i = pure.length() - 1; i >= 0; i--) {
            char c = pure.charAt(i);
            if (isOperand(c)) {
                s.push(String.valueOf(c));
            } else {
                String op1 = String.valueOf(s.pop());
                String op2 = String.valueOf(s.pop());
                double eval = evalate(op2, op1, c);
                s.push(Double.toString(eval));
            }
        }

        return Double.parseDouble(s.peek());
    }


    public static void main(String[] args) {

        double res = evaluatePrefix("+*1023");
        System.out.println(res);
    }

}
