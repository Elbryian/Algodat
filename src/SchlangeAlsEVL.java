/*
 * @author squast2s
 */

public class SchlangeAlsEVL<T> implements Schlange<T> {
    EVL<T> save = new EVL<>();
    @Override

    public void insert(T v) {
        save.insertLast(v);
    }

    @Override
    public T element() {
        return save.getFirst();
    }

    @Override
    public T remove() {
        return save.removeFirst();
    }

    @Override
    public int total() {
        return save.total();
    }

    @Override
    public boolean isEmpty() {
        return save.isEmpty();
    }
}
