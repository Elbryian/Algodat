/*
 * @author squast2s
 */

public class RingDyn<T> extends FeldAbstrakt<T> {
    private Feld<T> f = new FeldFix<T>(1);
    private int size;
    private int a;
    private int tot = 1;
    public int total() {
        return tot;
    }
    public int size() {
        return size;
    }

    private void adjustFirst(int s) {
        Feld<T> ff = new FeldFix<T>(s);
        tot = s;
        for (int i = 0 ; i < size ; ++i) {
            ff.set(i + 1, get(i));
        }
        f = ff;
    }

    private void adjustLast(int s) {
        Feld<T> ff = new FeldFix<T>(s);
        tot = s;
        for (int i = 0 ; i < size ; ++i) {
            ff.set(i, get(i));
        }
        f = ff;
    }

    public T get(int p) {
        checkIndex(p);
        return f.get((a+p) % total());
    }

    public T set(int p, T v) {
        checkIndex(p);
        return f.set((a+p) % total(), v);
    }

    public void insertFirst(T v) {
        if (total() == size()) {
            adjustFirst(total() * 2);
        }
        set(0, v);
        ++size;
    }

    public void insertLast(T v) {
        if (total() == size())  {
            adjustLast(total() * 2);
        }
        ++size;
        set(size - 1, v);
    }

    public T removeFirst() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        T v = get(0);
        if(total() / 4 >= size()-1 && total() >= 2) {
            Feld<T> ff = new FeldFix<T>(total()/2);
            tot = total()/2;
            for (int i = 0 ; i < tot ; ++i) {
                ff.set(i, get(i));
            }
            f = ff;
        }
        a = (a + 1) % total();
        --size;
        return v;
    }

    public T removeLast() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        T v = get(size - 1);
        if(total() / 4 >= size()-1 && total() >= 2) adjustLast(total()/2);

        --size;
        return v;
    }
}
