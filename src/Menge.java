public interface Menge<T> extends Kollektion<T> {
  int size();
  T element();
  boolean contains(T v);
  boolean insert(T v);
  boolean remove(T v);
}
