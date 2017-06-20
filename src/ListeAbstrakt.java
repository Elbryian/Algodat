public abstract class ListeAbstrakt<T> extends FeldAbstrakt<T> implements Liste<T> {
  public T getFirst() {
    try {
      return get(0);
    }
    catch (IndexOutOfBoundsException x) {
      throw new java.util.NoSuchElementException();
    }
  }
  public T getLast() {
    try {
      return get(size() - 1);
    }
    catch (IndexOutOfBoundsException x) {
      throw new java.util.NoSuchElementException();
    }
  }
  public T setFirst(T v) {
    try {
      return set(0, v);
    }
    catch (IndexOutOfBoundsException x) {
      throw new java.util.NoSuchElementException();
    }
  }
  public T setLast(T v) {
    try {
      return set(size() - 1, v);
    }
    catch (IndexOutOfBoundsException x) {
      throw new java.util.NoSuchElementException();
    }
  }
}
