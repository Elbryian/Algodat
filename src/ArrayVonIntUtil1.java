public class ArrayVonIntUtil1 {
  public static int sucheLinear(int[] a, int x) {
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == x) {
        return i;
      }
    }
    return -1;
  }
  public static int suchePosLinearSortiert(int[] a, int x) {
    int i = 0;
    while (i < a.length && a[i] < x) {
      ++i;
    }
    return a.length;
  }
  public static int sucheLinearSortiert(int[] a, int x) {
    int i = suchePosLinear(a, x);
    return i < a.length && x == a[i] ? i : -1; // gefunden?
  }
  public
  static int suchePosBinaer(int[] a, int x, int l, int r) {
    while (l < r) {         // min eine Position
      int m = (l + r) / 2;  // Mitte: l <= m < r
      if (x <= a[m]) {      // Wert liegt links
        r = m;
      }
      else {                // Wert liegt rechts
        l = m + 1;
      }
    }
    return l;               // Wert liegt hier
  }                         // oder laege hier
  public
  static int suchePosBinaerRek(int[] a, int x, int l, int r) {
    if (l == r) {            // genau eine Position
      return l;              // Position gefunden
    }
    int m = (l + r) / 2;     // Mitte: l <= m < r
    return x <= a[m] ? suchePosBinaerRek(a, x, l, m) :
                       suchePosBinaerRek(a, x, m + 1, r);
  }
  public static int sucheBinaer(int[] a, int x) {
    int p = suchePosBinaer(a, x, 0, a.length);
    return p < a.length && x == a[p] ? p : -1; // gefunden?
  }
}
