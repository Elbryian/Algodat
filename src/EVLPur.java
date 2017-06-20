/*
 * @author squast2s
 */

public class EVLPur<T> {
    public static int size;
    private class Item {
        private Item next;
        private T v;
        public Item(T v) { this.v = v; }
    }
    private Item first;

    public int total() {
        return 1 + 2 * size();
    }

    public boolean isEmpty() {
        return first == null;
    }
    // (nur) benoetigt fuer total()

    private int size() {
        return size;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return first.v;
    }

    public T setFirst(T v) {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T temp = first.v;
        first.v = v;
        return temp;
    }

    public void insertFirst(T v) {
        Item item = new Item(v);
        item.next = first;
        first = item;
        ++size;
    }

    public T removeFirst() {
        T v = getFirst();    // Vorbed.: Liste nicht leer
        first = first.next;  // zweites wird erstes
        --size;
        return v;
    }
    // removeLast() haette Aufwand proportional zu Laenge, ist daher nicht bereitzustellen
}
