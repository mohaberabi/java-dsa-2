import java.util.Arrays;

public class LinearProbbing {

    //assume -1 and -2 is not being added to the table
    // they also create a dummy node to store a deleted elements inside of the class to see  if ecah time it was deleted or not
    int[] table;


    private static final int DEFAULT_CAPACITY = 16;


    public LinearProbbing() {
        table = new int[DEFAULT_CAPACITY];
        Arrays.fill(table, -1);
    }


    int hash(int k) {
        return k % DEFAULT_CAPACITY;
    }


    private int size() {
        return table.length;
    }

    boolean search(int k) {
        int index = hash(k);

        int i = index;

        while (table[i] != -1) {
            if (table[i] == k) {
                return true;
            }
            i = (i + 1) % DEFAULT_CAPACITY;
            if (i == index) {
                return false;
            }
        }
        return false;
    }

    boolean put(int k) {

        if (size() == DEFAULT_CAPACITY) {
            return false;
        }
        int index = hash(k);
        int i = index;
        while (table[i] != -1 && table[i] != -2 && table[i] != k) {
            i = (i + 1) % DEFAULT_CAPACITY;
        }
        if (table[i] == k) {
            return false;
        } else {
            table[i] = k;
            return true;
        }

    }

    boolean remove(int k) {
        int index = hash(k);
        int i = index;
        while (table[i] != -1) {
            if (table[index] == k) {
                table[index] = -2;
                return true;
            }
            i = (i + 1) % DEFAULT_CAPACITY;
            if (i == index) {
                return false;
            }
        }
        return false;
    }

}
