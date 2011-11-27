package javtang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//from Guava
//public class Maps{ }

public final class Maps2 {
  public static <K, V> Pair<K, V> P(K a, V b) {
    return new Pair<K, V>(a, b);
  }

  @SafeVarargs
  public static <K, V, KK extends K, VV extends V> Map<K, V> newHashMap(Pair<KK, VV>... ps) {
    Map<K, V> result = new HashMap<>();
    for (Pair<KK, VV> p : ps) {
      result.put(p._1(), p._2());
    }
    return result;
  }

  @SafeVarargs
  public static <K, V, KK extends K, VV extends V> Map<K, V> newLinkedHashMap(Pair<KK, VV>... pairs) {
    Map<K, V> result = new LinkedHashMap<>();
    fill(result, pairs);
    return result;
  }

  public static String toString(Map<?, ?> map) {
    if (map == null) {
      return null;
    }
    StringBuilder sb = new StringBuilder(map.getClass().getSimpleName() + "{");
    sb.append(mkString(toPairs(map)));
    return sb.append("}").toString();
  }

  public static <A, B> List<Pair<A, B>> toPairs(Map<A, B> map) {
    if (map == null || map.isEmpty()) {
      return Collections.emptyList();
    }
    List<Pair<A, B>> result = new ArrayList<Pair<A, B>>(map.size());
    for (Map.Entry<A, B> it : map.entrySet()) {
      result.add(P(it.getKey(), it.getValue()));
    }
    return result;
  }

  @SafeVarargs
  private static <A, B, KK extends A, VV extends B> void fill(Map<A, B> target, Pair<KK, VV>... pairs) {
    if (pairs == null) {
      return;
    }
    for (Pair<KK, VV> p : pairs) {
      target.put(p._1(), p._2());
    }
  }

  private static String mkString(Collection<?> list) {
    if (list == null || list.isEmpty()) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Iterator<?> it = list.iterator();
    sb.append(it.next());
    for (; it.hasNext(); ) {
      sb.append(", ").append(it.next());
    }

    return sb.toString();
  }
}