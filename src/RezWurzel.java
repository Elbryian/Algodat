/*
 * @author squast2s
 */
public class RezWurzel implements Funktion {
	
	public RezWurzel(){
	}
	
	public boolean hatWertFuer(double x) {
		Wurzel f = new Wurzel();
		Abs g = new Abs();
		Funktion fg = new Kettenfunktion(f, g);
		Reziprok h = new Reziprok();
		Funktion fgh = new Kettenfunktion(h, fg);
		return fgh.hatWertFuer(x);
	}
	
	public double wert(double x) throws Exception {
		Wurzel f = new Wurzel();
		Abs g = new Abs();
		Funktion fg = new Kettenfunktion(f, g);
		Reziprok h = new Reziprok();
		Funktion fgh = new Kettenfunktion(h, fg);
		return fgh.wert(x);
	}
	
	public String toString(){
		return "f(g(x)) mit f(x) = 1/x und g(x) = f(g(x)) mit f(x) = sqrt(x) und g(x) = |x|";
	}
}