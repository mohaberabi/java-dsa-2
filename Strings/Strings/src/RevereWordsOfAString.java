import java.util.Stack;

public class RevereWordsOfAString {


    static String reverseWordsOptimal(String s) {


        int start = 0;
        char[] arr = s.toCharArray();
        for (int end = 0; end < s.length(); end++) {


            if (s.charAt(end) == ' ') {
                revers(arr, start, end - 1);
                start = end + 1;
            }

        }
        revers(arr, start, arr.length - 1);
        revers(arr, 0, arr.length - 1);
        return new String(arr);
    }


    static void revers(char[] arr, int i, int j) {


        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }

    static String reverseWordsInAString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        stack.push(sb.toString());

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop() + " ");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "i love coding";
        String rev = reverseWordsOptimal(s);
        System.out.println(rev);
    }
}
