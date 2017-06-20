public interface Zuordnung<K,V> extends Kollektion<K> {
  V get(K k);
  V set(K k, V v);
  V remove(K k);
}
