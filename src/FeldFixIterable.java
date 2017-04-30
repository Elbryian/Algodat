import java.util.Iterator;
public class FeldFixIterable<T>
  extends FeldFix<T> implements Iterable<T> {
  public FeldFixIterable(int size) {
    super(size);
  }
  public Iterator<T> iterator() {
    return new IteratorFuerFeld<T>(this);
  }
  public Iterator<T> iterator(int pos) {
    return new IteratorFuerFeld<T>(this, pos);
  }
  public Iterator<T> iterator(int pos, int end) {
    return new IteratorFuerFeld<T>(this, pos, end);
  }
}
