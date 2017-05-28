import java.util.Iterator;
public abstract class IterableAbstrakt<T>
implements Iterable<T> {
  public String toString() {
    String result = "(";
    Iterator<T> i = iterator();
    if (i.hasNext()) {
      result += i.next();
    }
    while (i.hasNext()) {
      result += "," + i.next();
    }
    return result + ")";
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    @SuppressWarnings("unchecked")
      Iterable<T> f = (Iterable<T>)o;
    Iterator<T> i1 = iterator();
    Iterator<T> i2 = f.iterator();
    while (i1.hasNext() && i2.hasNext()) {
      if (!i1.next().equals(i2.next())) {
        return false;
      }
    }
    return !(i1.hasNext() || i2.hasNext());
  }
}
