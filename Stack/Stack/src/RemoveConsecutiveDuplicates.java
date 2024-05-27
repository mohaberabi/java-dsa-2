import java.util.Stack;

public class RemoveConsecutiveDuplicates {

    public static String removeConsecutiveDuplicatesInPair(String str) {


        Stack<Character> stack = new Stack<>();


        for (char c : str.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }


        String ans = "";

        for (char c : stack) {
            ans += c;
        }
        return ans;
    }

    public static String removeConsecutiveDuplicates(String str) {


        Stack<Character> stack = new Stack<>();


        stack.push(str.charAt(0));

        for (char c : str.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() != c) {
                stack.push(c);
            }
        }


        String ans = "";

        for (char c : stack) {
            ans += c;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaabbaaccd";
        String ans = removeConsecutiveDuplicatesInPair(s);
        System.out.println(ans);
    }
}
