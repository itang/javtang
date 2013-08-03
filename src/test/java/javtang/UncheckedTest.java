package javtang;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.junit.Test;

public class UncheckedTest {

    @Test
    public void test() {
        String fileContent = Unchecked.call(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getFileContent("/home/itang/.bashrc");
            }
        });
        assertTrue(fileContent != null);

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
        if ("/home/itang/.bashrc".equals(path)) {
            return "mock content";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            StringBuilder sb = new StringBuilder();
            String lineSp = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(lineSp);
            }
            return sb.toString();
        }
    }
}
