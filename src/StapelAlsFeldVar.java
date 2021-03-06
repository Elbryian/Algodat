public class StapelAlsFeldVar<T> implements Stapel<T> {
  private FeldVar<T> f = new FeldVar<T>();
  public int total() {
    return f.total();
  }
  public boolean isEmpty() {
    return f.isEmpty();
  }
  public void insert(T v) {
    f.insert(v);
  }
  public T element() {
    try {
      return f.get(f.size() - 1);
    }
    catch (IndexOutOfBoundsException x) {
      throw new java.util.NoSuchElementException();
    }
  }
  public T remove() {
    return f.remove();
  }
}
