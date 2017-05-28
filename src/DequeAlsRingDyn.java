/*
 * @author squast2s
 */

public class DequeAlsRingDyn<T> implements Deque<T> {

    private Feld<T> f = new FeldFix<T>(1);
    private int size;
    private int a;
    private int tot = 1;

    public int total() {
        return tot;
    }

    private void adjustFirst(int s) {
        Feld<T> ff = new FeldFix<T>(s);
        tot = s;
        for (int i = 0 ; i < size ; ++i) {
            ff.set(i + 1, f.get(i));
        }
        f = ff;
    }

    public void insertFirst(T v) {
        if (total() == size()) {
            adjustFirst(total() * 2);
        }
        f.set(0, v);
        ++size;
    }

    public T getFirst() {
        if(isEmpty()) throw new java.util.NoSuchElementException();

        return f.get(0);
    }

    public T setFirst(T v) {
        if(v == null) throw new java.util.NoSuchElementException();

        T temp = getFirst();
        f.set(0,v);
        return temp;
    }

    public T removeFirst() {
        if(isEmpty()) throw new java.util.NoSuchElementException();
        T temp = f.get(0);
        if(total() / 4 >= size()-1 && total() >= 2) {
            f.set(0, null);
            Feld<T> ff = new FeldFix<T>(total()/2);
            tot = total()/2;
            for (int i = 0 ; i < tot ; ++i) {
                ff.set(i, f.get(i));
            }
            f = ff;
        }
        a = (a + 1) % total();
        --size;
        return temp;
    }

    private void adjustLast(int s) {
        Feld<T> ff = new FeldFix<T>(s);
        tot = s;
        for (int i = 0 ; i < size ; ++i) {
            ff.set(i, f.get(i));
        }
        f = ff;
    }
    
    public void insertLast(T v) {
        if(v == null) throw new java.util.NoSuchElementException();

        if (total() == size()) {
            adjustLast(total() * 2);
        }
        ++size;
        f.set(size - 1, v);

    }
    
    public T getLast() {
        if(isEmpty()) throw new java.util.NoSuchElementException();

        return f.get(size-1);
    }

    public T setLast(T v) {
        if(v == null) throw new java.util.NoSuchElementException();
        T temp = getLast();
        f.set(size-1,v);
        return temp;
    }

    public T removeLast() {
        T temp = f.get(size-1);
        if(f.get(0) == null) temp = f.get(total()-1);

        if(total() / 4 >= size()-1 && total() >= 2) {
            f.set(a, null);
            Feld<T> ff = new FeldFix<T>(total()/2);
            tot = total()/2;
            for (int i = 0 ; i < tot ; ++i) {
                ff.set(i, f.get(i));
            }
            f = ff;
        }
        a = (a + 1) % total();
        --size;
        return temp;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
