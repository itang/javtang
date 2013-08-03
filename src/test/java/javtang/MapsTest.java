package javtang;

import static javtang.Maps.P;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MapsTest extends Assert {

    @Test
    public void test_Maps() {
        // jdk 7
        Map<String, Object> map1 = new HashMap<>();
        System.out.println(Maps.toString(map1));

        // 匿名类, 构造块调用put方法
        @SuppressWarnings("serial")
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("hello", "world");
            }
        };
        System.out.println(Maps.toString(map));

        // 工具方法
        // @MARK javac 正常编译. idea 不能正确推断
        Map<String, Object> map2 = Maps.newHashMap(P("itang", "18"), P("tqibm", "30"));
        assertEquals("18", map2.get("itang"));
        assertEquals("30", map2.get("tqibm"));
        System.out.println(Maps.toString(map2));

        System.out.println(Maps.newLinkedHashMap(P("name", "itang"), P("password", "test")));
        System.out.println(Maps.toString(Maps.newLinkedHashMap(P("name", "itang"),
                P("password", "test"))));

        Map<String, Integer> map3 = Maps.newHashMap(P("math-score", 61), P("phy-score", 80));
        System.out.println(Maps.toString(map3));
    }
}
