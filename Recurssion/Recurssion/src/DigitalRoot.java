public class DigitalRoot {


    public static int digitalRoot(int n) {

        int sum = sumOFDigitsIterative(n);

        if (sum <= 9) {
            return sum;
        } else {

            int temp = sumOFDigitsIterative(sum);

            return temp;


        }

    }


    static int sumOFDigitsIterative(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int digital = digitalRoot(8426693);
        System.out.println(digital);
    }
}
