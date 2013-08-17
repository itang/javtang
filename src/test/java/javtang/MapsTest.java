package javtang;

import static org.hamcrest.CoreMatchers.*;
import static javtang.Maps.P;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MapsTest extends Assert {

    @Test
    public void merge() {
        Map<String, String> m1 = Maps.newHashMap("age", "18", "name", "itang");
        Map<String, String> m2 = Maps.newHashMap("age", "30", "name", "itang", "id", "1");
        Map<String, String> m3 = Maps.newHashMap("addr", "sz");
        Map<String, String> ret = Maps.merge(m1, m2, m3);
        assertThat(ret,
                equalTo(Maps.newHashMap("age", "30", "name", "itang", "id", "1", "addr", "sz")));
    }

    @Test
    public void test_Maps() {
        // jdk 7
        Map<String, Object> map1 = new HashMap<>();
        System.out.println(Maps.toString(map1));

        // 匿名类, 构造块调用put方法
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("hello", "world");
            }
        };
        System.out.println(Maps.toString(map));

        // 工具方法
        // @MARK javac 正常编译. idea 不能正确推断
        Map<String, String> map2 = Maps.newHashMapByPairs(P("itang", "18"), P("tqibm", "30"));
        assertEquals("18", map2.get("itang"));
        assertEquals("30", map2.get("tqibm"));
        System.out.println(Maps.toString(map2));

        assertEquals(map2, Maps.newHashMap("itang", "18", "tqibm", "30"));

        System.out.println(Maps.newLinkedHashMapByPairs(P("name", "itang"), P("password", "test")));
        System.out.println(Maps.toString(Maps.newLinkedHashMap(P("name", "itang"),
                P("password", "test"))));
        System.out
                .println(Maps.toString(Maps.newLinkedHashMap("name", "itang", "password", "test")));

        assertEquals(Maps.newLinkedHashMapByPairs(P("name", "itang"), P("password", "test")),
                Maps.newLinkedHashMap("name", "itang", "password", "test"));

        Map<String, Integer> map3 = Maps.newHashMapByPairs(P("math-score", 61), P("phy-score", 80));
        System.out.println(Maps.toString(map3));

        Map<String, ? extends Object> map4 = Maps.newHashMap("name", "itang", "age", 30, "addr",
                "sz");
        assertEquals(30, map4.get("age"));
    }
}
