public class Y {
  static String s = "";

  public static void start() {
    try {
      methode();
    }
    catch (Exception e) {
      s += "start_catch ";
    }
    System.out.println(s);
  }

  static void methode() throws RuntimeException {
    try {
      s += "methode_try ";
      throw new IllegalArgumentException();
    }
    catch(IllegalArgumentException ie) {
      s += "methode_catch ";
    }
    finally {
      s += "methode_finally ";
      throw new IllegalArgumentException();
    }
  }
}
