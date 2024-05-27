public class TrappingRainWater {


    int maxWaterNaive(int[] bars, int n) {
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int lMax = bars[i];

            for (int j = 0; j < i; j++) {
                lMax = Math.max(lMax, bars[j]);
            }

            int rMax = bars[i];
            for (int j = i + 1; j < n; j++) {
                rMax = Math.max(rMax, bars[j]);
            }

            res = Math.min(lMax, rMax) - bars[i];
        }

        return res;
    }


    int maxWaterOptimal(int[] bars, int n) {
        int[] lMax = new int[n];
        int[] rMAx = new int[n];

        int res = 0;

        lMax[0] = 0;
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(bars[i], lMax[i - 1]);
        }
        rMAx[n - 1] = bars[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMAx[i] = Math.max(bars[i], rMAx[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            res += Math.min(lMax[i], rMAx[i]) - bars[i];
        }
        return res;
    }
}
