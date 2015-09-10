import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 10/09/15
 * Time: 10:36
 */
public class UrlEncodeTextFile {

    public static void main(String[] args) {

        String folderPath = "D:\\queries";

        Path source = Paths.get(folderPath, "3_search_8011.txt");
        Path dest = Paths.get(folderPath, "search_8011.txt");
        Charset charset = Charset.forName("UTF-8");

        try {
            BufferedWriter writer = Files.newBufferedWriter(dest, charset, StandardOpenOption.CREATE);
            BufferedReader reader = Files.newBufferedReader(source, charset);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String ul = URLEncoder.encode(line, "UTF-8") + "\n";
                writer.write(ul, 0, ul.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
