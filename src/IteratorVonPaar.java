/*
 * @author squast2s
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorVonPaar<E,Z> implements Iterator<Paar<E,Z>> {
   
    private Iterator<E> e;
    private Iterator<Z> z;
   
    public IteratorVonPaar(Iterator<E> e, Iterator<Z> z){
        super();
        this.e = e;
        this.z = z;
    }
   
    public boolean hasNext() {
        return e.hasNext() & z.hasNext();
    }
 
   
    public Paar<E, Z> next() {
        if (hasNext()) {
            return new Paar<E,Z>(e.next(),z.next());
        } else {
            throw new NoSuchElementException();
        }
    }
   
    public void remove() {
        throw new UnsupportedOperationException();
    }
   
   
}