public class IsRotatedByTwo {


    static boolean isRotatedByTwo(String a, String b) {
        if (a.equals(b)) {
            return false;
        }
        if (a.length() < 3 || b.length() < 3) {
            return false;
        }
        String c = a + a;
        if (c.indexOf(b, 2) != -1) {
            return true;
        }

        if (c.indexOf(b, a.length() - 2) != -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "rh";
        String b = "hr";

        boolean r = isRotatedByTwo(a, b);
        System.out.println(r);
    }
}
