public class EVL<T> {
  private class Item {
    private Item next;
    private T v;
    public Item(T v) { this.v = v; }
  }
  private Item first;
  private Item last;
  // nur solche Methoden bereitgestellt, die von Stapel/Schlange benoetigt werden
  // oder die sich mit konstantem Aufwand implementieren lassen:
  public int total() {
    return 2 + 2 * size();
  }
  public boolean isEmpty() {
    return first == null;
  }
  // (nur) benoetigt fuer total()
  private int size() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T getFirst() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return first.v;
  }
  public T getLast() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T setFirst(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T setLast(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public void insertFirst(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public void insertLast(T v) {
    Item item = new Item(v); // neues Hilfsobjekt
    if (isEmpty()) {         // wenn Liste leer ...
      first = item;          // ... H.O. einziges
    }
    else {                   // ... sonst ...
      last.next = item;      // ... H.O. hintenan
    }
    last = item;             // H.O. in jedem Fall letztes
  }
  public T removeFirst() {
    T v = getFirst();    // Vorbed.: Liste nicht leer
    first = first.next;  // zweites wird erstes
    if (first == null) { // evtl. Liste dann leer
      last = null;
    }
    return v;
  }
  // removeLast() haette Aufwand proportional zu Laenge, ist daher nicht bereitzustellen
}
