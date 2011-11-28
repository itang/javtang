package javtang


import java.io.{FileReader, BufferedReader}
import java.util.concurrent.Callable

import org.scalatest.FunSuite
import com.google.common.base.Optional

class UncheckedTest extends FunSuite {
  test("Unchecked Test") {
    val fileContent: Optional[String] = Unchecked.call(new Callable[String] {
      def call: String = {
        return getFileContent("/home/itang/.bashrc")
      }
    })

    println(fileContent.get())

    try {
      Unchecked.call(new Callable[String] {
        def call: String = {
          return getFileContent("/home/itang/.bashrc_bad")
        }
      })
    }
    catch {
      case e: RuntimeException => {
        System.out.println(e.getMessage)
      }
    }
  }

  implicit def optionalToOption[String](optional: Optional[String]): Option[String] = {
    if (optional.isPresent) Some(optional.get()) else None
  }

  test("Unchecked for scala") {
    val result = Unchecked.call(new Callable[String] {
      def call() = "hello"
    })

    //FIXME 好吧, 在match pattern下implicit不起作用?
    optionalToOption(result) match {
      case Some(msg) => assert(msg === "hello")
      case None =>
    }
  }

  private def getFileContent(path: String): String = {
    val reader: BufferedReader = new BufferedReader(new FileReader(path))
    var line: String = null
    val sb: StringBuilder = new StringBuilder
    val lineSp: String = System.getProperty("line.separator")
    while (({
      line = reader.readLine;
      line
    }) != null) {
      sb.append(line).append(lineSp)
    }
    return sb.toString
  }
}