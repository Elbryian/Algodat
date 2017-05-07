class A { }
class B extends A { }
class C extends A { }
class D extends C { }
class E { }

public class Inferenz {
  public static <T>   T   f(T   x, T   y)  { return null; }
  public static <T>   T   g(T[] x, T[] y)  { return null; }
  public static <T>   T[] h(T   x, T[] y)  { return null; }
  public static <T,U> U   k(U[] x, T   y)  { return null; }

  public static void main(String[] args) {
    A        z01 = f(new A(),     new C());
    A        z02 = f(new C(),     new A());
    A        z03 = f(new B(),     new D());
    A        z04 = f(new C(),     new D());
    B        z05 = f(new A(),     new C());
    B        z06 = f(new C(),     new D());
    E        z07 = f(new E(),     new A());
    Object   z08 = f(new B(),     new E());
    C        z09 = f(new B(),     new D());
    A[]      z10 = f(new B[1],    new C[1]);
    B[]      z11 = f(new B[1],    new C[1]);
    Object[] z12 = f(new B[1],    new C());
    Object[] z13 = f(new B[1],    new D[1]);
    Object   z14 = f(new D[1],    new E[1]);
    Object   z15 = f(new B[1],    1);
    Object   z16 = f(new B[1],    new int[1]);
    A[]      z17 = g(new B[1],    new D[1]);
    A        z18 = g(new C[1],    new D[1]);
    A        z19 = g(new B[1],    new E[1]);
    A        z20 = g(new A[1][1], new C[1]);
    A[]      z21 = g(new B[1][1], new D[1][1]);
    Object   z22 = g(new B[1],    new int[1]);
    Object   z23 = g(new B[1],    new int[1][1]);
    A[]      z24 = h(new B(),     new B[1]);
    A[]      z25 = h(new B[1],    new B());
    C[]      z26 = h(new D(),     new B[1]);
    A[]      z27 = h(new B(),     new D[1]);
    A[][]    z28 = h(new B[1],    new C[1][1]);
    Object   z29 = h(new C[1][1], new B[1]);
    C[][]    z30 = h(new C[1],    new C[1]);
    E        z31 = k(new E[1],    new E());
    E        z32 = k(new E(),     new E[1]);
    A        z33 = k(new D[1],    new E[1]);
    B        z34 = k(new C[1],    new B());
    Object[] z35 = k(new B[1][1], new E[1][1]);
  }
}

