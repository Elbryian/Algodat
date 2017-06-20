public class ArrayVonIntUtil3 extends ArrayVonIntUtil2 {
  public static void sortMerge(int[] a) {
    sortMerge(a, 0, a.length);
  }

  /* Sortiere den Bereich des Feldes a von 'l' bis vor 'r'
   * 'l' ist erste Position des zu sortierenden Bereichs
   * 'r' ist erste Position nach dem Bereich
   */
  private static void sortMerge(int[] a, int l, int r) {
    if (r - l <= 1) {    // hoechstens ein Wert
      return;            // => Bereich ist schon sortiert
    }
    int m = (l + r) / 2; // Ende links / Anfang rechts

    sortMerge(a, l, m);  // sortiere linken Teil
    sortMerge(a, m, r);  // sortiere rechten Teil

    int[] tmp = new int[r-l];  // Hilfsfeld zum Mischen
    int   i = 0;               // Index fuer Hilfsfeld
    int   jl = l;              // Index fuer linken Teil
    int   jr = m;              // Index fuer rechten Teil

    while (jl < m && jr < r) { // solange noch Werte
      if (a[jl] <= a[jr]) {    // kleinerer Wert links
        tmp[i++] = a[jl++];    // uebertrage nach tmp
      }                        // ruecke jeweils vor
      else {                   // kleinerer Wert rechts
        tmp[i++] = a[jr++];    // uebertrage nach tmp
      }                        // ruecke jeweils vor
    }
    // jetzt ist links oder rechts kein Wert mehr uebrig
    while (jl < m) {      // uebertrage Rest nach tmp
      tmp[i++] = a[jl++];
    }
    while (jr < r) {      // uebertrage Rest nach tmp
      tmp[i++] = a[jr++];
    }
    //in tmp liegt sortierte Teilfolge

    // kopiere tmp nach a
    for (int k = 0; k < tmp.length; ++k) {
      a[l + k] = tmp[k];
    }
  }
}
