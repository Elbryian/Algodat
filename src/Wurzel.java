/*
 * @author squast2s
 */
public class Wurzel implements Funktion {
	
	public Wurzel(){
	}
	
	public boolean hatWertFuer(double x){
		if(x>=0){return true;}
		else return false;
	}
	
	public double wert(double x) {
		return Math.sqrt(x);
	}
	
}