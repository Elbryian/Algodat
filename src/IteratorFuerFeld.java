public class IteratorFuerFeld<T>
  implements java.util.Iterator<T> {
  private Feld<T> f;
  private int pos; // aktuelle Position
  private int end; // Endposition
  public IteratorFuerFeld(Feld<T> f) {
    this(f, 0);
  }
  public IteratorFuerFeld(Feld<T> f, int pos) {
    this(f, pos, f.size());
  }
  public IteratorFuerFeld(Feld<T> f, int pos, int end) {
    if (!(0 <= pos && pos <= end && end <= f.size())) {
      throw new IndexOutOfBoundsException();
    }
    this.f = f;
    this.pos = pos;
    this.end = end;
  }
  public boolean hasNext() {
    return pos < end;
  }
  public T next() {
    try {
      if (hasNext()) {
        return f.get(pos++);
      }
    }
    catch (IndexOutOfBoundsException e) {
    }
    throw new java.util.NoSuchElementException();
  }
}
