@SuppressWarnings("unchecked")
public class Felder {
  public static Comparable min(Comparable[] cf)
  throws Exception {
    if (cf.length == 0) { throw new Exception(); }
    Comparable min = cf[0];
    for (int i = 1 ; i < cf.length ; ++i) {
      if (cf[i].compareTo(min) < 0) {
        min = cf[i];
      }
    }
    return min;
  }
}
