/*
 * @author squast2s
 */
public class Polynom implements Funktion {
	
	private double[] a;
	
	public Polynom(double[] a){
		this.a = a;
	}
	
	public boolean hatWertFuer(double x) {
		return true;
	}
	
	public double wert(double x) {
		double p = 0.0;
		for (int i=a.length-1; i>=0; i--) {
			p = p * x + a[i];
		}
		return p;
	}
	
}