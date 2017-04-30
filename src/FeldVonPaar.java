/*
 * @author squast2s
 */
public class FeldVonPaar<E,Z> implements Feld<Paar<E,Z>> {
	
	private Feld<E> a;
    private Feld<Z> b;
    private int length;
	
	public FeldVonPaar(Feld<E> a, Feld<Z> b) {
		this.length = (a.size() < b.size()) ? a.size() : b.size();
        this.a = a;
        this.b = b;
	}
	
	public Paar<E,Z> get(int i) throws ArrayIndexOutOfBoundsException {
        if(i < length) {
            return new Paar<E,Z>(a.get(i), b.get(i));
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public int size() {
        return this.length;
    }
 
    public Paar<E,Z> set(int i, Paar<E,Z> paar) {
        Paar<E,Z> old = new Paar<E,Z>(a.get(i), b.get(i));
       
        this.a.set(i, paar.erstes());
        this.b.set(i, paar.zweites());
 
        return old;
    }

	public boolean isEmpty() {
		return this.length == 0;
	}

	public void swap(int p, int q) {
		if (p > size() || q > size())
			throw new IndexOutOfBoundsException();
		E tempE = a.get(p);
		Z tempZ = b.get(p);
		a.set(p, a.get(q));
		b.set(p, b.get(q));
		a.set(q, tempE);
		b.set(q, tempZ);
	}
	
}