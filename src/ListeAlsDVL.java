/*
 * @author squast2s
 */

import java.util.Iterator;

public class ListeAlsDVL<T> implements Liste<T> {

    private final DVL<T> l = new DVL<>();

    @Override
    public int total() {
        return l.total();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public T set(int i, T e) {
        return l.set(i, e);
    }

    @Override
    public void swap(int p, int q) {
        this.l.swap(p,q);
    }

    @Override
    public T get(int i) {
        return l.get(i);
    }

    @Override
    public T setLast(T e) {
        return l.setLast(e);
    }

    @Override
    public T setFirst(T e) {
        return l.setFirst(e);
    }

    @Override
    public T getFirst() {
        return l.getFirst();
    }

    @Override
    public T getLast() {
        return l.getLast();
    }

    @Override
    public void insert(int i, T e) {
        l.insert(i, e);
    }

    @Override
    public T remove(int i) {
        return l.remove(i);
    }

    @Override
    public void insertFirst(T e) {
        l.insertFirst(e);
    }

    @Override
    public void insertLast(T e) {
        l.insertLast(e);
    }

    @Override
    public T removeFirst() {
        return l.removeFirst();
    }

    @Override
    public T removeLast() {
        return l.removeLast();
    }

    @Override
    public java.util.Iterator<T> iterator(int i) {
        return l.iterator(i);
    }

    @Override
    public Iterator<T> iterator(int p, int e) {
        return null;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return l.iterator();
    }
}
