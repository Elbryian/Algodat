public class FarbPunkt extends Punkt {
  private Farbe f;
  public FarbPunkt() {
    f = new Farbe();   // schwarz
  }
  public FarbPunkt(double x, double y, Farbe f) {
    super(x, y);
    this.f = f;        // f wird geteilt!
  }
  public FarbPunkt(FarbPunkt fp) {
    super(fp);
    this.f = fp.f;
  }
  public boolean equals(FarbPunkt fp) {
    return super.equals(fp) && f.equals(fp.f);
  }
  public Farbe farbe() {
    return f;
  }
  public FarbPunkt verschiebe(double dx, double dy) {
    super.verschiebe(dx, dy);
    return this;
  }
  public String toString() {
    return super.toString() + ":" + f;
  }
}
