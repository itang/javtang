package javtang;

import static javtang.Strings.mkString;
import static javtang.Strings.repeat;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class StringsTest extends Assert {

    @Test
    public void test_repeat() {
        assertEquals("", repeat("*", -1));
        assertEquals("", repeat("*", 0));
        assertEquals("*", repeat("*", 1));
        assertEquals("**", repeat("*", 2));
        assertEquals("***", repeat("*", 3));
        assertEquals("=|=|=|", repeat("=|", 3));
    }

    @Test
    public void test_mkString() {
        assertEquals("", mkString(Lists.newArrayList(), ","));
        assertEquals("a", mkString(Lists.newArrayList("a"), ","));
        assertEquals("a,b", mkString(Lists.newArrayList("a", "b"), ","));
    }
}
