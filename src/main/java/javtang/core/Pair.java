package javtang.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Pair<A, B> implements Iterable<Object> {

    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A $1() {
        return a;
    }

    public B $2() {
        return b;
    }

    @Override
    public Iterator<Object> iterator() {
        List<Object> wrapper = new ArrayList<>();
        wrapper.add(this.a);
        wrapper.add(this.b);
        return Collections.unmodifiableList(wrapper).iterator();
    }

    @Override
    public String toString() {
        return a + ":" + quote(b);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair<?, ?> other = (Pair<?, ?>) obj;
        if (a == null) {
            if (other.a != null)
                return false;
        } else if (!a.equals(other.a))
            return false;
        if (b == null) {
            if (other.b != null)
                return false;
        } else if (!b.equals(other.b))
            return false;
        return true;
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
