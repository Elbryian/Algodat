/*
 * @author squast2s
 */

public class DVL<T> implements Iterable<T> {
  private class Item {
    private Item prev;
    private Item next;
    public T e;
    public Item(T e) { this.e = e; }
  }

  public class Iterator implements java.util.Iterator<T> {
    private Item current;

    public Iterator() {
      current = first;
    }
    public Iterator(int p) {
      current = getItem(p);
    }
    public boolean hasNext() {
      return current != null;
    }
    public T next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      T e = current.e;
      current = current.next;
      return e;
    }
    public void remove() {
      if(current == null || current.prev == null) {
        throw new java.util.NoSuchElementException();
      }
      removeItem(current.prev);
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
    int size = 0;
    for(Item item = first; item != null; item = item.next) {
      size++;
    }
    return size;
  }

  public T getFirst() {
    if(isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return first.e;
  }

  public T getLast() {
    if(isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return last.e;
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
    return item.e;
  }

  public T setFirst(T e) {
    if(isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    final T elem = first.e;
    first.e = e;
    return elem;
  }

  public T setLast(T e) {
    if(isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    final T elem = last.e;
    last.e = e;
    return elem;
  }

  public T set(int p, T e) {
    final Item item = getItem(p);
    if(item == null) {
      throw new IndexOutOfBoundsException();
    }
    final T elem = item.e;
    item.e = e;
    return elem;
  }

  public void insertFirst(T e) {
    final Item item = new Item(e);
    if(isEmpty()) {
      first = last = item;
    } else {
      item.next = first;
      assert first.prev == null;
      first.prev = item;
      first = item;
    }
  }

  public void insertLast(T e) {
    final Item item = new Item(e);
    if(isEmpty()) {
      first = last = item;
    } else {
      item.prev = last;
      assert last.next == null;
      last.next = item;
      last = item;
    }
  }

  public void insert(int p, T e) {
    Item item = new Item(e);
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
    if(isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return removeItem(first);
  }

  public T removeLast() {
    if(isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return removeItem(last);
  }

  // eigene Methode, da von remove() von DVL und Iterator verwendet
  public T removeItem(Item item) {
    Item prev = item.prev;   // Vorg\"anger
    Item next = item.next;   // Nachfolger
    if (prev == null) {      // erstes wird gel\"oscht
      first = next;
    }
    else {
      item.prev.next = next; // Vorg\"anger verw.\ auf Nachfolger
    }
    if (next == null) {      // letztes Element wird gel\"oscht
      last = prev;
    }
    else {                   // Nachfolger verw.\ auf Vorg\"anger
      item.next.prev = prev;
    }
    return item.e;
  }

  public T remove(int p) {
    Item item  = getItem(p);
    if (item == null) { // falls p == size()
      throw new IndexOutOfBoundsException();
    }
    return removeItem(item);
  }

  public void swap(int p, int q) {
    T temp1 = getItem(p).e;
    this.set(p, getItem(q).e);
    this.set(q, temp1);
  }

  public Iterator iterator() {
    return new Iterator();
  }

  public Iterator iterator(int p) {
    return new Iterator(p);
  }
}
