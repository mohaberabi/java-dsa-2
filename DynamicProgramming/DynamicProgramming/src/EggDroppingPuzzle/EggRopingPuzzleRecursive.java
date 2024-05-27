package EggDroppingPuzzle;

public class EggRopingPuzzleRecursive {


    static int eggDrop(int floor, int eggs) {
        if (eggs == 1 || eggs == 0)
            return eggs;
        if (floor == 1)
            return eggs;
        int min = Integer.MAX_VALUE;
        int x, res;
        for (x = 1; x <= eggs; x++) {
            res = Math.max(eggDrop(floor - 1, x - 1),
                    eggDrop(floor, eggs - x));
            if (res < min)
                min = res;
        }
        return min + 1;
    }

}
