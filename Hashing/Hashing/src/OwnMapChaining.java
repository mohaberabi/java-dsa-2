import java.util.ArrayList;

import LinkedList.Entry;
import LinkedList.Node;
import LinkedList.OwnLinkedList;

public class OwnMapChaining<K, V> {


    private final int bucket;

    private final ArrayList<OwnLinkedList<Entry<K, V>>> table;


    public OwnMapChaining(int x) {
        this.bucket = x;

        table = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            table.add(new OwnLinkedList<>());
        }
    }


    public void insert(K key, V val) {
        int index = hash(key);
        Entry<K, V> e = new Entry<>(key, val);
        table.get(index).addLast(e);
    }


    private int hash(K k) {
        return Math.abs(k.hashCode() % bucket);
    }


    public V get(K k) {
        int index = hash(k);
        OwnLinkedList<LinkedList.Entry<K, V>> curr = table.get(index);

        Node<Entry<K, V>> entry = curr.getHead();

        while (entry != null) {
            if (entry.data.getKey().equals(k)) {
                return entry.data.getValue();
            }

            entry = entry.next;
        }
        return null;
    }


    private boolean containsKey(K k) {
        int index = hash(k);


        OwnLinkedList<Entry<K, V>> list = table.get(index);


        if (list == null) {
            return false;
        }
        if (list.getHead() == null) {
            return false;
        }
        if (list.getHead().data.getKey().equals(k)) {
            return true;
        }

        return list.search(k);
    }

    void remove(K key) {
        int index = hash(key);
        OwnLinkedList<LinkedList.Entry<K, V>> list = table.get(index);
        list.removeByKey(key);
    }


    public static void main(String[] args) {

        OwnMapChaining<Integer, Integer> map = new OwnMapChaining<>(13);

        map.insert(1, 3);

        int val = map.get(1);
        System.out.println(val);
        map.remove(1);
        System.out.println(map.get(1));
        boolean ans1 = map.containsKey(1);
        map.insert(1, 100);
        boolean ans2 = map.containsKey(1);
        System.out.println(ans1);
        System.out.println(ans2);

    }
}
