/*
 * @author squast2s
 */

import java.util.Iterator;

public class FeldIterableVonPaar<E,Z> implements Feld<Paar<E,Z>>, FeldIterable<Paar<E,Z>> {
	
	private int length;
	
	private Feld<E> e;
	private Feld<Z> z;
	
	public boolean isEmpty() {
		return this.length == 0;
	}

	public FeldIterableVonPaar(Feld<E> e, Feld<Z> z){
		this.e = e;
		this.z = z;
		this.length = (e.size() < z.size()) ? e.size() : z.size();
	}
	
	public int size() {
		return this.length;
	}

	public Paar<E,Z> get(int i) {
		return new Paar<E,Z>(e.get(i), z.get(i));
	}

	public Paar<E,Z> set(int i, Paar<E,Z> paar) {
		Paar<E,Z> vorheriges = this.get(i);
		e.set(i, paar.erstes());
		z.set(i, paar.zweites());
		
		return vorheriges;
	}

	public void swap(int i, int u) {
		Paar<E,Z> paar1 = new Paar<E,Z> (e.get(i), z.get(i));
		Paar<E,Z> paar2 = new Paar<E,Z> (e.get(u), z.get(u));
		Paar<E,Z> temp = paar1;
		paar1 = paar2;
		paar2 = temp;	
		
		e.set(i, paar1.erstes()) ;
		z.set(i, paar1.zweites()) ;

		e.set(u, paar2.erstes()) ;
		z.set(u, paar2.zweites()) ;
	}

	public Iterator<Paar<E, Z>> iterator() {
		return new IteratorVonPaar<E, Z>(((FeldIterable<E>)e).iterator(), ((FeldIterable<Z>)z).iterator());
	}
}