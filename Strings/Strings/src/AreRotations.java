public class AreRotations {


    boolean areRotations(String a, String b) {


        if (a.length() != b.length()) {
            return false;
        }
        String c = a + b;

        return c.contains(b);
    }
}
