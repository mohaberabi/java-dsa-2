import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CaseSort {


    static String caseSort(String s) {


        ArrayList<Character> lower = new ArrayList<>();
        ArrayList<Character> upper = new ArrayList<>();

        int i = 0;
        int j = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower.add(c);
            } else {
                upper.add(c);
            }
        }
        Collections.sort(lower);
        Collections.sort(upper);

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(upper.get(i++));
            } else {
                sb.append(lower.get(j++));
            }
        }

        return sb.toString();

    }


    public static void main(String[] args) {

        String s = caseSort("srbDKi");


        System.out.println(s);
//        System.out.println((int) 'a');
//        System.out.println(b);
    }

}
