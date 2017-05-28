/*
 * @author squast2s
 */

public class SchlangeAlsRingDyn<T> implements Schlange<T>{

    private Feld<T> f = new FeldFix<T>(1);
    private int size;
    private int a;
    private int tot = 1;

    private void adjustFirst(int s) {
        Feld<T> ff = new FeldFix<T>(s);
        tot = s;
        for (int i = 0 ; i < size ; ++i) {
            ff.set(i, f.get(i));
        }
        f = ff;
    }

    public int size() {
        return size;
    }

    @Override
    public void insert(T v) {
        if(v == null) throw new java.util.NoSuchElementException();

        if (total() == size()) {
            adjustFirst(total() * 2);
        }
        f.set(size, v);
        ++size;
    }

    @Override
    public T element(){
        if(isEmpty()) throw new java.util.NoSuchElementException();
        return f.get(a);
    }

    @Override
    public T remove() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        T temp = f.get(a);
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

    @Override
    public int total() {
        return tot;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
