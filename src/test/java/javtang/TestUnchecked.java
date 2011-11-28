package javtang;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;


public class TestUnchecked {
  @Test
  public void test() {
    Optional<String> fileContent = Unchecked.call(new Callable<String>() {
      @Override
      public String call() throws Exception {
        return getFileContent("/home/itang/.bashrc");
      }
    });
    assertTrue(fileContent.isPresent());
    System.out.println(fileContent.get());

    try {
      Unchecked.call(new Callable<String>() {
        @Override
        public String call() throws Exception {
          return getFileContent("/home/itang/.bashrc_bad");
        }
      });
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  private static String getFileContent(String path) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(path));
    String line = null;
    StringBuilder sb = new StringBuilder();
    String lineSp = System.getProperty("line.separator");
    while ((line = reader.readLine()) != null) {
      sb.append(line).append(lineSp);
    }
    return sb.toString();
  }
}
