public class RingVar<T> extends FeldAbstrakt<T> {
  private static final int MAX_SIZE = 6;
  private final Feld<T> f = new FeldFix<T>(MAX_SIZE);
  private int size;
  private int a;
  public int total() {
    return f.size();
  }
  public int size() {
    return size;
  }
  public T get(int p) {
    checkIndex(p);
    return f.get((a+p) % f.size());
  }
  public T set(int p, T v) {
    checkIndex(p);
    return f.set((a+p) % f.size(), v);
  }
  public void insertFirst(T v) {
    if (size == f.size()) {
      throw new IllegalStateException();
    }
    a = (a - 1 + f.size()) % f.size();
    ++size;
    set(0, v);
  }
  public void insertLast(T v) {
    if (size == f.size()) {
      throw new IllegalStateException();
    }
    ++size;
    set(size - 1, v);
  }
  public T removeFirst() {
    if (size == 0) {
      throw new java.util.NoSuchElementException();
    }
    T v = get(0);
    a = (a + 1) % f.size();
    --size;
    return v;
  }
  public T removeLast() {
    if (size == 0) {
      throw new java.util.NoSuchElementException();
    }
    T v = get(size - 1);
    --size;
    return v;
  }
}
