public class X {
  public static void start() {
    try {
      methode1();
    }
    catch (ArithmeticException ae) {
      System.out.println("start ");
    }
  }

  public static void methode1() throws ArithmeticException {
    try {
      methode2(0);
    }
    catch (ArithmeticException ae) {
      System.out.println("methode1 ");
    }
  }

  public static void methode2(int x) throws ArithmeticException {
    if (x==0) {
      throw new ArithmeticException();
    }
    System.out.println("methode2 ");
  }
}
