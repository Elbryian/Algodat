/*
 * @author squast2s
 */

public class EVL<T> {
  public static int size;
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
    return size;
  }

  public T getFirst() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return first.v;
  }

  public T getLast() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return last.v;
  }

  public T setFirst(T v) {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    T temp = first.v;
    first.v = v;
    return temp;
  }

  public T setLast(T v) {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    T temp = last.v;
    last.v = v;
    return temp;
  }

  public void insertFirst(T v) {
    Item item = new Item(v);
    if(isEmpty()) last = item;
    item.next = first;
    first = item;
    ++size;
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
    ++size;
  }
  public T removeFirst() {
    T v = getFirst();    // Vorbed.: Liste nicht leer
    first = first.next;  // zweites wird erstes
    if (first == null) { // evtl. Liste dann leer
      last = null;
    }
    --size;
    return v;
  }
  // removeLast() haette Aufwand proportional zu Laenge, ist daher nicht bereitzustellen
}
