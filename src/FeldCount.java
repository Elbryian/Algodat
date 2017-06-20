public class FeldCount<T>
implements Feld<T> {
  private Feld<T> f;
  private static int count;
  public FeldCount(Feld<T> f) {
    this.f = f;
  }
  public static int count() {
    return count;
  }
  public static void resetCount() {
    count = 0;
  }
  public int total() {
    return f.total();
  }
  public boolean isEmpty() {
    return f.isEmpty();
  }
  public int size() {
    return f.size();
  }
  public T get(int p) {
    return f.get(p);
  }
  public T set(int p, T v) {
    T r = f.set(p, v);
    ++count;
    return r;
  }
  public void swap(int p, int q) {
    if (p != q) {
      f.swap(p, q);
      count += 2;
    }
  }
  public java.util.Iterator<T> iterator() {
    return f.iterator();
  }
  public java.util.Iterator<T> iterator(int p) {
    return f.iterator(p);
  }
  public java.util.Iterator<T> iterator(int p, int e) {
    return f.iterator(p, e);
  }
}
