package javtang

import java.util.{Map => JMap, HashMap => JHashMap}
import org.scalatest.FunSuite
import javtang.Maps2._


class Maps2Test extends FunSuite {
  test("Construct java.util.Map") {
    val map1: JMap[String, Any] = new JHashMap[String, Any]
    println(map1)
    println(Maps2.toString(map1))

    // 匿名类, 构造块调用put方法
    val map: JMap[String, AnyRef] = new JHashMap[String, AnyRef] {
      put("message", "hello,world")
    }

    assert(map.size() === 1)
    assert(map.get("message") === "hello,world")
  }

  test("Maps2.newHashMap|newLinkedHashMap") {
    // 工具方法
    //@MARK javac 正常编译. idea 不能正确推断
    val map2: JMap[String, AnyRef] = Maps2.newHashMap(P("itang", "18"), P("tqibm", "30"))

    assert(map2.get("itang") === "18")
    println(map2)
    println(Maps2.toString(map2))

    println(Maps2.newLinkedHashMap(P("name", "itang"), P("password", "test")))
    println(Maps2.toString(Maps2.newLinkedHashMap(P("name", "itang"), P("password", "test"))))

    val map3: JMap[String, Int] = Maps2.newHashMap(P("math-score", 61), P("phy-score", 80))
    println(Maps2.toString(map3))
  }
}