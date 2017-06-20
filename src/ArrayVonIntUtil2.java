public class ArrayVonIntUtil2 extends ArrayVonIntUtil1 {
  public static void swap(int[] a, int p1, int p2) {
    if (p1 != p2) {
      int tmp = a[p1];
      a[p1] = a[p2];
      a[p2] = tmp;
    }
  }
  public static int minPos(int[] a, int i) {
    int p = i;
    for (int j = i + 1; j < a.length; ++j) {
      if (a[p] > a[j]) {
        p = j;
      }
    }
    return p;
  }  
  public static void sortSelect(int[] a) {
    // fuer jede Position des Feldes, bis vorletzter:
    for (int i = 0; i < a.length-1; ++i) {
      // suche Pos. von kleinstem Element im Rest des Feldes
      // und tausche mit aktueller Position
      swap(a, i, minPos(a, i));
    }
  }
  public static void sortInsert(int[] a) {
    // fuer jedes Element, ab dem zweiten:
    for (int i = 1; i < a.length; ++i) {
      // solange vorhergehendes Element kleiner:
      for (int j = i; j > 0 && a[j-1] > a[j]; --j) {
        // tausche Element nach links
        swap(a, j-1, j);
      }
    }
  }
  public static void sortBubble(int[] a) {
    int p = a.length-1; // Position letzter Tausch
    while (p > 0) {     // solange vertauscht wurde
      int r = p;        // rechte Grenze fuer Iteration
      p = 0;            // bisher keine Vertauschung
      for (int i = 0; i < r; ++i) {
        if (a[i] > a[i+1]) { // falls Tausch notwendig:
          swap(a, i, i+1);   // tausche und
          p = i;             // merke Position
        }
      }
    }
  }
}
