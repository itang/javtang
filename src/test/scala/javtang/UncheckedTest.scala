package javtang


import java.io.{FileReader, BufferedReader}
import java.util.concurrent.Callable

import org.scalatest.FunSuite

class UncheckedTest extends FunSuite {
  test("Unchecked Test") {
    val fileContent: String = Unchecked.`with`(new Callable[String] {
      def call: String = {
        return getFileContent("/home/itang/.bashrc")
      }
    })

    println(fileContent)

    try {
      Unchecked.`with`(new Callable[String] {
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