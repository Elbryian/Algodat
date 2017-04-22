public class Parabel implements Funktion {
  private double a, b, c; // unschoen, aber kurz
  // $f(x) = a \cdot x^2 + b \cdot x + c$
  public Parabel(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  public boolean hatWertFuer(double x) {
    return true;
  }
  public double wert(double x) {
    return a*x*x + b*x + c;
  }
  public String toString() { // unschoen f. Werte <= 0
    return a + "*x^2 + " + b + "*x + " + c;
  }
}
