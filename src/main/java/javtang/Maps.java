package javtang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import javtang.core.Pair;

/**
 * Map Helper class.
 * 
 * @author itang
 * 
 */
@Immutable
public abstract class Maps {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SafeVarargs
    public static <K, V> Map<K, V> merge(Map m1, Map... ms) {
        if (ms == null || ms.length == 0) {
            return m1;
        }
        Map ret = m1;
        for (Map m : ms) {
            ret.putAll(m);
        }

        return ret;
    }

    public static <K, V> Pair<K, V> P(@Nullable final K a, @Nullable final V b) {
        return new Pair<K, V>(a, b);
    }

    @SafeVarargs
    public static <K, V> Map<K, V> newHashMapByPairs(Pair<? extends K, ? extends V> p,
            Pair<? extends K, ? extends V>... ps) {
        return fill(fill(new HashMap<K, V>(), p), ps);
    }

    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> Map<K, V> newHashMap(K k0, V v0) {
        return newHashMapByPairs(P(k0, v0));
    }

    public static <K, V> Map<K, V> newHashMap(K k0, V v0, K k1, V v1) {
        return newHashMapByPairs(P(k0, v0), P(k1, v1));
    }

    public static <K, V> Map<K, V> newHashMap(K k0, V v0, K k1, V v1, K k2, V v2) {
        return newHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2));
    }

    public static <K, V> Map<K, V> newHashMap(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3) {
        return newHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2), P(k3, v3));
    }

    public static <K, V> Map<K, V> newHashMap(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3, K k4,
            V v4) {
        return newHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2), P(k3, v3), P(k4, v4));
    }

    public static <K, V> Map<K, V> newHashMap(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3, K k4,
            V v4, K k5, V v5) {
        return newHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2), P(k3, v3), P(k4, v4), P(k5, v5));
    }

    @SafeVarargs
    public static <K, V> Map<K, V> newLinkedHashMapByPairs(Pair<? extends K, ? extends V> p,
            Pair<? extends K, ? extends V>... ps) {
        return fill(fill(new LinkedHashMap<K, V>(), p), ps);
    }

    public static <K, V> Map<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k0, V v0) {
        return newLinkedHashMapByPairs(P(k0, v0));
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k0, V v0, K k1, V v1) {
        return newLinkedHashMapByPairs(P(k0, v0), P(k1, v1));
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k0, V v0, K k1, V v1, K k2, V v2) {
        return newLinkedHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2));
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3) {
        return newLinkedHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2), P(k3, v3));
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3,
            K k4, V v4) {
        return newLinkedHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2), P(k3, v3), P(k4, v4));
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3,
            K k4, V v4, K k5, V v5) {
        return newLinkedHashMapByPairs(P(k0, v0), P(k1, v1), P(k2, v2), P(k3, v3), P(k4, v4),
                P(k5, v5));
    }

    public static String toString(@Nullable Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(map.getClass().getSimpleName() + "{");
        sb.append(Strings.mkString(toPairs(map), ", "));
        return sb.append("}").toString();
    }

    public static <A, B> List<Pair<A, B>> toPairs(@Nullable Map<A, B> map) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyList();
        }
        List<Pair<A, B>> result = new ArrayList<>(map.size());
        for (Map.Entry<A, B> it : map.entrySet()) {
            result.add(P(it.getKey(), it.getValue()));
        }
        return result;
    }

    @SafeVarargs
    private static <K, V> Map<K, V> fill(Map<K, V> target, Pair<? extends K, ? extends V>... pairs) {
        if (pairs == null) {
            return null;
        }
        for (Pair<? extends K, ? extends V> p : pairs) {
            target.put(p.$1(), p.$2());
        }
        return target;
    }
}
