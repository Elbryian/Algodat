public class IteratorFuerFeld<T>
  implements java.util.Iterator<T> {
  private Feld<T> f;
  private int p; // aktuelle Position
  private int e; // Endposition
  public IteratorFuerFeld(Feld<T> f) {
    this(f, 0);
  }
  public IteratorFuerFeld(Feld<T> f, int p) {
    this(f, p, f.size());
  }
  public IteratorFuerFeld(Feld<T> f, int p, int e) {
    if (!(0 <= p && p <= e && e <= f.size())) {
      throw new IndexOutOfBoundsException();
    }
    this.f = f;
    this.p = p;
    this.e = e;
  }
  public boolean hasNext() {
    return p < e;
  }
  public T next() {
    if (hasNext()) {
      try {
        return f.get(p++);
      }
      catch (IndexOutOfBoundsException x) {
      }
    }
    throw new java.util.NoSuchElementException();
  }
}
