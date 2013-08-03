package javtang;

import java.util.Iterator;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * String Helper class.
 * 
 * @author itang
 * 
 */
@Immutable
public abstract class Strings {

    public static String repeat(@Nullable final String s, final int count) {
        if (s == null || count <= 0) {
            return "";
        } else if (count == 1) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(s);
            }
            return sb.toString();
        }
    }

    public static String mkString(@Nullable final Iterable<?> iterable, final String sep) {
        if (iterable == null || !iterable.iterator().hasNext()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Iterator<?> it = iterable.iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(sep).append(it.next());
        }
        return sb.toString();
    }
}
