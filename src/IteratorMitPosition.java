import java.util.Iterator;
public class IteratorMitPosition<T> implements Iterator<T> {
  private Iterator<T> i;
  private int p;
  private int e;
  public IteratorMitPosition(Iterable<T> iterable) {
    this(iterable, 0);
  }
  public IteratorMitPosition(Iterable<T> iterable, int p) {
    this(iterable, p, Integer.MAX_VALUE);
  }
  public IteratorMitPosition(Iterable<T> iterable, int p, int e) {
    this.i = iterable.iterator();
    for (int pp = 0; pp < p; ++pp) {
      if (!i.hasNext()) {
        throw new IndexOutOfBoundsException();
      }
      i.next();
    }
    this.p = p;
    this.e = e;
  }
  public boolean hasNext() {
    return i.hasNext() && p < e;
  }
  public T next() {
    if (!hasNext()) {
      throw new java.util.NoSuchElementException();
    }
    ++p;
    return i.next();
  }
}
