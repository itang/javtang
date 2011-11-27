package javtang;

import java.util.concurrent.Callable;

public class Unchecked {
  public static <T> T with(Callable<T> call) {
    try {
      return call.call();
    } catch (RuntimeException e) {
      throw e;
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
