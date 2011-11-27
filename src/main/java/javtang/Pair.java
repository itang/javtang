package javtang;

public class Pair<A, B> {
  private final A a;
  private final B b;

  public Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }

  public A _1() {
    return a;
  }

  public B _2() {
    return b;
  }

  @Override
  public String toString() {
    return a + ":" + quote(b);
  }

  private static String quote(Object o) {
    if (o == null) {
      return "null";
    }
    if (o instanceof String) {
      return "\"" + o + "\"";
    }
    return o.toString();
  }
}