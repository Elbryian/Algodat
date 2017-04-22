/*
 * @author Stephan Quast
 */
public class Frau extends Person {
	
	public static int anzahlfrau = 0;
	
	public Frau (String name, int alter, int groesse, int gewicht) {
		super(name,alter,groesse,gewicht);
		anzahlfrau++;
	}
	
	public int alter() {
		return super.alter;
	}
	
	public String chromosomen() {
		return "XX";
	}
	
	public int groesse() {
		return super.groesse;
	}
	
	public int gewicht() {
		return super.gewicht-5;
	}
	
	public int preisHaarschnitt() {
		double haarp = (double) super.alter;
		haarp = haarp*2.0;
		haarp = haarp/3.0;
		haarp = haarp+20.0;
		haarp = Math.round(haarp);
		return (int) haarp;
	}
	
	public static int anzahl() {
		return anzahlfrau;
	}
	
}