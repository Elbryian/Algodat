/*
 * @author squast2s
 */

public class FeldDyn<T> extends FeldAbstrakt<T> {
    private Feld<T> f = new FeldFix<T>(1);
    private int size;
    public int total() {
        return f.size();
    }
    public int size() {
        return size;
    }
    public T get(int p) {
        checkIndex(p);
        return f.get(p);
    }
    
    public T set(int p, T v) {
        checkIndex(p);
        return f.set(p, v);
    }
    
    private void adjust(int s) {
        Feld<T> ff = new FeldFix<T>(s);
        for (int i = 0 ; i < size ; ++i) {
            ff.set(i, get(i));
        }
        f = ff;
    }
    private void adjustInsert() {
        if (size == f.size()) {
            adjust(f.size() * 2);
        }
    }
    private void adjustRemove() {
    	
    }
    public void insert(T v) {
        adjustInsert();
        f.set(size++, v);
    }
    public T remove() {

        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        T temp = f.get(--size);
        if(f.size() / 4 >= size() && f.size() >= 2) adjust(f.size()/2);
        return temp;
    }
}
