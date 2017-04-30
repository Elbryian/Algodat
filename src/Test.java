public class Test {
  public static void main(String[] args) throws Exception {
    
	  /*Funktion f = new Parabel(2, 0, 0);     // f(x) = x^2
    Funktion g = new Sinus();              // f(x) = sin(x)
    Funktion fg = new Kettenfunktion(f,g); // f(x) = (sin(x))^2

    Wertetabelle.ausgabe(f, 0, 1, 7);
    Wertetabelle.ausgabe(g, 0, Math.PI, 7);
    Wertetabelle.ausgabe(fg, 0, Math.PI, 7);
    */
	  
	  /*Polynom ff = new Polynom (new double[]{-1,2,1,3,4});
	  Funktion f = (Funktion)ff;
	  f.toString();
    
	  System.out.println(f);
	  */
	  
	  Paar<String,String> p1 = new Paar<String,String> ("Hallo","Welt!");
	  p1.erstes();
	  p1.zweites();
	  p1.toString();
	  Paar<String,String> p2 = new Paar<String,String> ("Hola","Mundo!");
	  p1.equals(p2);
	  
	  System.out.println(p1);
  }
}
