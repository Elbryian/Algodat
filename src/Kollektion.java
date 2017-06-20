public interface Kollektion<T> {
  /**
   * @return intern insgesamt verbrauchter Speicherplatz
   */
  int total();
  boolean isEmpty();
}
