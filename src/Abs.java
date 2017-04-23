/*
 * @author squast2s
 */
public class Abs implements Funktion {
	
	public Abs(){
	}
	
	public boolean hatWertFuer(double x) {
		return true;
	}
	
	public double wert(double x) {
		return Math.abs(x);
	}
	
}