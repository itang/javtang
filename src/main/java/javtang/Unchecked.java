package javtang;

import com.google.common.base.Optional;

import java.util.concurrent.Callable;

public class Unchecked {

  public static <T> Optional<T> call(Callable<T> callable) {
    return call(callable, null);
  }

  @SuppressWarnings("unchecked")
  public static <T> Optional<T> call(Callable<T> callable, String message) {
    return Optional.fromNullable((T) invoke(callable, Optional.fromNullable(message)));
  }

  public static void run(Runnable runnable) {
    run(runnable, null);
  }

  public static void run(Runnable run, String message) {
    invoke(run, Optional.fromNullable(message));
  }

  @SuppressWarnings("unchecked")
  private static <T> T invoke(Object block, Optional<String> message) {
    try {
      if (block instanceof Callable) {
        return ((Callable<T>) block).call();
      } else if (block instanceof Runnable) {
        ((Runnable) block).run();
        return null;
      } else {
        throw new RuntimeException("执行块的类型目前只支持:Callable, Runnable");
      }
    } catch (Throwable e) {
      if (message.isPresent()) {
        throw new RuntimeException(message.get(), e);
      } else {
        throw new RuntimeException(e);
      }
    }
  }
}