/*
 * @author squast2s
 */
public class Reziprok implements Funktion {
	
	public Reziprok(){		
	}
	
	public boolean hatWertFuer(double x) {
		if(x!=0) {return true;}
		else return false;
	}
	
	public double wert(double x) {
		return 1/x;
	}
	
}