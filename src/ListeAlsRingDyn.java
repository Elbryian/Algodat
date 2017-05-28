/*
 * @author squast2s
 */

public class ListeAlsRingDyn<T> extends ListeAbstrakt<T> {
    private Feld<T> f = new FeldFix<T>(1);
    private int size;
    private int a;
    private int tot = 1;
    private int fv;
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
        f.set(0, v);
        ++size;
    }

    public void insertLast(T v) {
        if (total() == size()) {
            adjustLast(total() * 2);
        }
        ++size;
        f.set(size - 1, v);

    }

    public T removeFirst() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        T v = f.get(0);
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
        T v = f.get(size);
        if(total() / 4 >= size()-1 && total() >= 2) adjustLast(total()/2);

        --size;
        return v;
    }

    private void moveL(int von, int bis) {
        Feld<T> ff = new FeldFix<T>(total());
        for(int i = von; i < bis; ++i) {
            ff.set(i ,f.get(i + 1));
        }
        for(int i = bis; i < total(); ++i) {
            ff.set(i ,f.get(i));
        }
        f = ff;
    }

    private void moveR(int von, int bis) {
        Feld<T> ff = new FeldFix<T>(total());
        for(int i = 0; i < von ; ++i) {
            ff.set(i ,f.get(i));
        }
        for(int i = von; i < total()-1; ++i) {
            ff.set(i + 1,f.get(i));
        }
        f = ff;
    }

    public void insert(int p, T v) {
        if(p < size()/2) {
            moveL(0, p);
        }
        else {
            if (total() == size()) {
                adjustLast(total() * 2);
            }
            ++size;
            moveR(p, total());
        }
        f.set(p, v);
    }

    private void moveRD(int p) {
        Feld<T> ff = new FeldFix<T>(total());
        for(int i = 0; i < p ; ++i) {
            ff.set(i ,f.get(i));
        }
        for(int i = p; i < size(); ++i) {
            ff.set(i,f.get(i+1));
        }
        f = ff;
    }

    private void moveLD(int p) {
        Feld<T> ff = new FeldFix<T>(total());
        for(int i = a; i < p; ++i) {
            ff.set(i + 1,f.get(i));
        }
        for(int i = p; i < size()-1; ++i) {
            ff.set(i ,f.get(i));
        }
        f = ff;
    }

    public T remove(int p) {
        T temp = f.get(p);
        if(p < size()/2) {
            moveLD(p);
            ++a;
        }
        else {
            --size;
            moveRD(p);
        }
        if (total()/4 > size()) {
            adjustLast(total() / 2);
        }
        return temp;
    }
}
