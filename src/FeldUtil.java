public class FeldUtil {
  public static <T> void loesche(Feld<T> f) {
    for (int i = 0; i < f.size(); ++i) {
      f.set(i, null);
    }
  }
  public static <T> T letztes(Feld<T> f1, Feld<T> f2) {
    return f1.size() > f2.size() ? f1.get(f1.size()-1)
                                 : f2.get(f2.size()-1);
  }
public static <T> T min(Feld<T> f,java.util.Comparator<T> c){
  try {
    T min = f.get(0);
    for (int i = 1; i < f.size(); ++i) {
      T o = f.get(i);
      if (c.compare(min, o) > 0) { min = o; }
    }
    return min;
  }
  catch (IndexOutOfBoundsException e) {
    throw new java.util.NoSuchElementException();
  }
}
}
