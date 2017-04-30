/*
public class FeldFix<T> { // noch unvollstaendig
*/
public class FeldFix<T> implements Feld<T> {
  private T[] a;
  public FeldFix(int size) {
    @SuppressWarnings("unchecked")
      T[] tmp = (T[])new Object[size];
    a = tmp;
  }
  public boolean isEmpty() {
    return a.length == 0;
  }
  public int size() {
    return a.length;
  }
  public T get(int p) {
    try {
      return a[p];
    }
    catch (ArrayIndexOutOfBoundsException ex) {
      throw new IndexOutOfBoundsException(ex.getMessage());
    }
  }
  public T set(int p, T e) {
    try {
      T result = a[p];
      a[p] = e;
      return result;
    }
    catch (ArrayIndexOutOfBoundsException ex) {
      throw new IndexOutOfBoundsException(ex.getMessage());
    }
  }
  public void swap(int p, int q) {
    try {
      T tmp = a[p];
      a[p] = a[q];
      a[q] = tmp;
    }
    catch (ArrayIndexOutOfBoundsException ex) {
      throw new IndexOutOfBoundsException(ex.getMessage());
    }
  }
}
