/*
 * @author Stephan Quast
 */
public class Mann extends Person {
	
	public static int anzahlmann = 0;
	
	public Mann(String name, int alter, int groesse, int gewicht) {
		super(name,alter,groesse,gewicht);
		anzahlmann++;
	}
	
	public int alter(){
		return super.alter;
	}
	
	public String chromosomen() {
		return "XY";
	}
	
	public int groesse() {
		return super.groesse+5;
	}
	
	public int gewicht() {
		return super.gewicht;
	}
	
	public int preisHaarschnitt() {
		double haarp = (double) super.alter;
		haarp = haarp/4.0;
		haarp = haarp + 10.0;
		haarp = Math.round(haarp);
		return (int) haarp;
	}
	
	public static int anzahl() {
		return anzahlmann;
	}
	
}