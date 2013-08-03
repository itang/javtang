package javtang;

import java.util.concurrent.Callable;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * 将代码从checked-exception 转换为 unchecked-exception 运行.
 * 
 * @author itang
 * 
 */
@Immutable
public class Unchecked {

    public static <T> T call(Callable<T> callable) {
        return call(callable, null);
    }

    public static <T> T call(Callable<T> callable, @Nullable String message) {
        return invoke(callable, message);
    }

    public static void run(Runnable runnable) {
        run(runnable, null);
    }

    public static void run(Runnable run, @Nullable String message) {
        invoke(run, message);
    }

    @SuppressWarnings("unchecked")
    private static <T> T invoke(Object block, @Nullable String message) {
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
            if (message != null) {
                throw new RuntimeException(message, e);
            } else {
                throw new RuntimeException(e);
            }
        }
    }
}
