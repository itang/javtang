package javtang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static javtang.Maps2.P;

public class TestMaps2 {
  @Test
  public void test() {
    // jdk 7
    Map<String, Object> map1 = new HashMap<>();
    System.out.println(map1);
    System.out.println(Maps2.toString(map1));

    // 匿名类, 构造块调用put方法
    @SuppressWarnings("serial")
    Map<String, Object> map = new HashMap<String, Object>() {
      {
        put("hello", "world");
      }
    };
    System.out.println(Maps2.toString(map));

    // 工具方法
    //@MARK javac 正常编译. idea 不能正确推断
    Map<String, Object> map2 = Maps2.newHashMap(P("itang", "18"), P("tqibm", "30"));
    System.out.println(map2.get("itang"));
    System.out.println(map2);
    System.out.println(Maps2.toString(map2));

    System.out.println(Maps2.newLinkedHashMap(P("name", "itang"), P("password", "test")));
    System.out.println(Maps2.toString(Maps2.newLinkedHashMap(P("name", "itang"), P("password", "test"))));

    Map<String, Integer> map3 = Maps2.newHashMap(P("math-score", 61), P("phy-score", 80));
    System.out.println(Maps2.toString(map3));
  }
}
