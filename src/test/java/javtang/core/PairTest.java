package javtang.core;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class PairTest extends Assert {

    @Test
    public void testPair() {
        Pair<String, Integer> p = new Pair<>("a", 1);
        assertEquals(p.$1(), "a");
        assertEquals((int) p.$2(), 1);

        Iterator<Object> it = p.iterator();
        assertTrue(it.hasNext());
        assertEquals(it.next(), p.$1());
        assertEquals(it.next(), p.$2());

        List<Object> list = Lists.newArrayList(p);
        assertEquals(list.size(), 2);

        for (Object o : p) {
            System.out.println(o);
        }
    }
}
