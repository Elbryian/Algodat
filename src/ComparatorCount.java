import java.util.*;

public class ComparatorCount<T> implements Comparator<T> {
  private Comparator<? super T> comp;
  private int count;
  public ComparatorCount(Comparator<? super T> comp) {
    this.comp = comp;
  }
  public int compare(T a, T b) {
    ++count;
    return comp.compare(a, b);
  }
  public int count() {
    return count;
  }
  public void countReset() {
    count = 0;
  }
}
