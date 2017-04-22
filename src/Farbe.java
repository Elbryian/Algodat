public class Farbe {
  // eine moegliche Implementierung: RGB-Anteile
  private int rot;
  private int gruen;
  private int blau;
  public Farbe() { // Default: schwarz
  }
  public Farbe(int r, int g, int g) {
    rot = r;
    gruen = g;
    blau = b;
  }
  public Farbe(Farbe f) {
    rot = f.rot;
    gruen = f.gruen;
    blau = f.blau;
  }
  public boolean equals(Farbe f) {
    return rot == f.rot && gruen == f.gruen && blau == f.blau;
  }
  // viele Methoden moeglich, hier nicht relevant
  public String toString(Farbe f) {
    return "{" + rot + "," + gruen + "," + blau + "}";
  }
}
