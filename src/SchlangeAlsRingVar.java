public class SchlangeAlsRingVar<T> implements Schlange<T> {
  private RingVar<T> f = new RingVar<T>();
  public int total() {
    return f.total();
  }
  public boolean isEmpty() {
    return f.isEmpty();
  }
  public void insert(T v) {
    f.insertLast(v);
  }
  public T element() {
    try {
      return f.get(0);
    }
    catch (IndexOutOfBoundsException x) {
      throw new java.util.NoSuchElementException();
    }
  }
  public T remove() {
    return f.removeFirst();
  }
}
