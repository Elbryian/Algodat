/*
 * @author squast2s
 */
public abstract class Person {
	
	private String name;
	int alter;
	int groesse;
	int gewicht;
	private static final int volljaehrig = 18;
	
	public static int anzahlperson = 0;
	
	public Person(String name, int alter, int groesse, int gewicht) {
		this.name = name;
		this.alter = alter;
		this.groesse = groesse;
		this.gewicht = gewicht;
		anzahlperson++;
	}
	
	public String name() {
		return this.name;
	}
	
	public static int volljaehrigkeitsAlter() {
		return volljaehrig;
	}
	
	public boolean istVolljaehrig() {
		return this.alter >= volljaehrig;
	}
	
	public String toString() {
		return this.name+" "+this.chromosomen()+" "+this.alter+" "+this.istVolljaehrig()+" "+this.groesse()+" "+this.gewicht()+" "+this.preisHaarschnitt();		
	}
	
	public static int anzahl(){
		return anzahlperson;
	}

	public abstract int alter();
	
	public abstract int groesse();
	
	public abstract int gewicht();
	
	public abstract String chromosomen();
	
	public abstract int preisHaarschnitt();
	
}