public abstract class FeldAbstrakt<T>
extends IterableAbstrakt<T>
implements Feld<T> {
  protected void checkIndex(int p) {
    if (!(0 <= p && p < size())) {
      throw new IndexOutOfBoundsException();
    }    
  }
  public boolean isEmpty() {
    return size() == 0;
  }
  public void swap(int p, int q) {
    if (p != q) {
      set(q, set(p, get(q)));
    }
  }
  public java.util.Iterator<T> iterator() {
    return new IteratorFuerFeld<T>(this);
  }
  public java.util.Iterator<T> iterator(int p) {
    return new IteratorFuerFeld<T>(this, p);
  }
  public java.util.Iterator<T> iterator(int p, int e) {
    return new IteratorFuerFeld<T>(this, p, e);
  }
}
