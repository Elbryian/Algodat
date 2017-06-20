public class ArrayVonIntUtil4 extends ArrayVonIntUtil3 {
  public static void sortQuick(int[] a) {
    sortQuick(a, 0, a.length-1);
  }

  private static int pivot(int[] a, int l, int r) {
    return (l + r + 1) / 2; // oder alternative Wahl
  }

  /* Sortiere den Bereich des Feldes a von 'l' bis 'r'
   * 'l' ist erste Position in dem zu sortierenden Bereich
   * 'r' ist letzte Position in(!) dem Bereich
   */
  private static void sortQuick(int[] a, int l, int r) {
    if (l >= r) {           // max. ein Element?
      return;               // dann fertig
    }
    int p = pivot(a, l, r); // l <= p <= r
    // bringe kleine Elemente nach links, grosse nach rechts
    swap(a, p, r);          // tausche Pivot nach rechts
    int il = l;             // "Linksaussen"
    int ir = r-1;           // "Rechtsaussen"
    do {                    // laufe aufeinander zu
      while (il <= ir && a[il] < a[r]) { // linker Wert o.k.
        ++il;               // laufe nach "innen"
      }
      while (il < ir && a[ir] >= a[r]) { // rechter Wert o.k.
        --ir;               // laufe nach "innen"
      }
      if (il < ir) {        // Fehlstand entdeckt?
        swap(a, il++, ir);  // tausche linken und rechten Wert
      }                     // dann il, stets ir weiterruecken
    } while (il <= --ir);
    p = il;                 // Pivot folgt auf linken Teil
    swap(a, p, r);          // tausche Pivot nach innen

    sortQuick(a, l, p-1);   // linken Teil sortieren
    sortQuick(a, p+1, r);   // rechten Teil sortieren
  }
}
