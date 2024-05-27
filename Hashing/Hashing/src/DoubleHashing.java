import java.util.Arrays;

class DoubleHashingMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public DoubleHashingMap() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int index = hash1(key);
        int step = hash2(key);

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].value = value;
                return;
            }
            index = (index + step) % table.length;
        }

        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = hash1(key);
        int step = hash2(key);

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + step) % table.length;
        }

        return null;
    }

    public void remove(K key) {
        int index = hash1(key);
        int step = hash2(key);

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                size--;
                return;
            }
            index = (index + step) % table.length;
        }
    }

    public int size() {
        return size;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    private int hash1(K key) {
        return key.hashCode() % table.length;
    }

    private int hash2(K key) {
        // Choose a secondary hash function here, e.g., prime number close to table.length.
        // This is just an example; you may need to adapt it based on your specific use case.
        return 7 - (key.hashCode() % 7);
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

