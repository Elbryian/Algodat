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
	
	public String toString(){
		String p = "";
		int i = a.length-1;
		p = p + a[i] +"*x^"+ (i);
		for (int j=a.length-2; j>=0; j--) {
			p = p +" + "+ a[j] +"*x^"+(j);
		}
		return p;
	}
}