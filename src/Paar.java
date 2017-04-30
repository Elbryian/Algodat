/*
 * @author squast2s
 */
public class Paar<E,Z> {
	
	private E e;
	private Z z;
	
	public Paar(E e, Z z) {
		this.e = e;
		this.z = z;
	}
	
	public E erstes() {
		return e;
	}
	
	public Z zweites() {
		return z;
	}
	
	public E setErstes(E e) {
		E eOld = this.e;
		this.e = e;
		return eOld;
	}
	
	public Z setZweites(Z z) {
		Z zOld = this.z;
		this.z = z;
		return zOld;
	}
	
	public boolean equals(Paar<E, Z> other) {
		return (this.e.equals(other.erstes()) && this.z.equals(other.zweites()));
	}
	
	public String toString(){
		return ("("+e.toString()+","+z.toString()+")");
	}
}