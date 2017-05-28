public class DVL<T> implements Iterable<T> {
  private class Item {
    private Item prev;
    private Item next;
    private T v;
    public Item(T v) { this.v = v; }
  }
  private class Iterator implements java.util.Iterator<T> {
    private Item current = first;
    public boolean hasNext() {
      return current != null;
    }
    public T next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      T v = current.v;
      current = current.next;
      return v;
    }
  }
  private Item first;
  private Item last;
  public int total() {
    return 2 + 3 * size();
  }
  public boolean isEmpty() {
    return first == null;
  }
  public int size() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T getFirst() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T getLast() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  // eigene Methode, da an mehreren Stellen verwendet
  private Item getItem(int p) {
    if (p < 0) {
      throw new IndexOutOfBoundsException();
    }
    Item current = first;
    for (int i = 0; i < p; ++i) {
      if (current == null) {
        throw new IndexOutOfBoundsException();
      }
      current = current.next;
    }
    return current; // null, falls p == size()
  }
  public T get(int p) {
    Item item  = getItem(p);
    if (item == null) { // falls p == size()
      throw new IndexOutOfBoundsException();
    }
    return item.v;
  }
  public T setFirst(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T setLast(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }  
  public T set(int p, T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public void insertFirst(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public void insertLast(T v) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public void insert(int p, T v) {
    Item item = new Item(v);
    item.next = getItem(p);       // p-Item wird Nachfolger

    if (item.next ==  null) {     // Einf\"ugen am Ende
      item.prev = last;           // last wird Vorg\"anger
      last = item;                // neues wird letztes
    }
    else {                        // min. 1 Element folgt
      item.prev = item.next.prev; // \"ubernehme Vorg\"anger
      item.next.prev = item;      // Vorg\"anger von Nachfolger
    }
    if (item.prev == null) {      // Einf\"ugen am Anfang
      first = item;               // neues wird erstes
    }
    else {                        // min. 1 Element davor
      item.prev.next = item;
    }
  }
  public T removeFirst() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public T removeLast() {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  // eigene Methode, da von remove() von DVL und Iterator verwendet
  public T removeItem(Item item) {
    Item prev = item.prev;   // Vorg\"anger
    Item next = item.next;   // Nachfolger
    if (prev == null) {      // erstes wird gel\"oscht
      first = next;
    }
    else {
      prev.next = next;      // Vorg\"anger verw.\ auf Nachfolger
    }
    if (next == null) {      // letztes Element wird gel\"oscht
      last = prev;
    }
    else {
      next.prev = prev;      // Nachfolger verw.\ auf Vorg\"anger
    }
    return item.v;
  }
  public T remove(int p) {
    Item item = getItem(p);
    if (item == null) { // falls p == size()
      throw new IndexOutOfBoundsException();
    }
    return removeItem(item);
  }
  public void swap(int p, int q) {
    // zu implementieren
    throw new UnsupportedOperationException();
  }
  public java.util.Iterator<T> iterator() {
    return new Iterator();
  }
  public java.util.Iterator<T> iterator(int p) {
    return new IteratorMitPosition<T>(this, p);
  }
  public java.util.Iterator<T> iterator(int p, int e) {
    return new IteratorMitPosition<T>(this, p, e);
  }
}
