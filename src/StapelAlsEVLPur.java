/*
 * @author squast2s
 */

public class StapelAlsEVLPur<T> implements Stapel<T>{
    EVLPur<T> save = new EVLPur<>();

    @Override
    public void insert(T v) {
        save.insertFirst(v);
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
