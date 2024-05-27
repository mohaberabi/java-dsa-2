public class PowerOfNumber {


    int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int temp = pow(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }

    int powIterative(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * x;
            }
            x = x * x;
            n = n / 2;
        }
        return res;
    }

    int powIterativeBitWise(int x, int n) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            n = n >> 1;
        }
        return res;
    }
}
